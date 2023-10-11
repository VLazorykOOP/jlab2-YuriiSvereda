import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VeryLongNumber {
    private List<Integer> digits;

    public VeryLongNumber(String number) {
        digits = new ArrayList<>();
        for (int i = number.length() - 1; i >= 0; i--) {
            digits.add(Character.getNumericValue(number.charAt(i)));
        }
    }

    public VeryLongNumber(List<Integer> digits) {
        this.digits = new ArrayList<>(digits);
    }

    public VeryLongNumber add(VeryLongNumber other) {
        // Implementation of addition
        // ...
        int maxLen = Math.max(this.digits.size(), other.digits.size());
        int carry = 0;
        List<Integer> resultDigits = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            int thisDigit = (i < this.digits.size()) ? this.digits.get(i) : 0;
            int otherDigit = (i < other.digits.size()) ? other.digits.get(i) : 0;

            int sum = thisDigit + otherDigit + carry;
            carry = sum / 10;
            resultDigits.add(sum % 10);
        }

        if (carry > 0) {
            resultDigits.add(carry);
        }
        return new VeryLongNumber(resultDigits);
    }

    public VeryLongNumber subtract(VeryLongNumber other) {
        int maxLen = Math.max(this.digits.size(), other.digits.size());
        int borrow = 0;
        List<Integer> resultDigits = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            int thisDigit = (i < this.digits.size()) ? this.digits.get(i) : 0;
            int otherDigit = (i < other.digits.size()) ? other.digits.get(i) : 0;

            int diff = thisDigit - otherDigit - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            resultDigits.add(diff);
        }

        while (resultDigits.size() > 1 && resultDigits.get(resultDigits.size() - 1) == 0) {
            resultDigits.remove(resultDigits.size() - 1);
        }

        return new VeryLongNumber(resultDigits);
    }


    public VeryLongNumber multiply(VeryLongNumber other) {
        List<Integer> resultDigits = new ArrayList<>(Collections.nCopies(this.digits.size() + other.digits.size(), 0));

        for (int i = 0; i < this.digits.size(); i++) {
            int carry = 0;
            for (int j = 0; j < other.digits.size(); j++) {
                int product = this.digits.get(i) * other.digits.get(j) + resultDigits.get(i + j) + carry;
                carry = product / 10;
                resultDigits.set(i + j, product % 10);
            }
            resultDigits.set(i + other.digits.size(), resultDigits.get(i + other.digits.size()) + carry);
        }

        while (resultDigits.size() > 1 && resultDigits.get(resultDigits.size() - 1) == 0) {
            resultDigits.remove(resultDigits.size() - 1);
        }

        return new VeryLongNumber(resultDigits);
    }


    public VeryLongNumber divide(VeryLongNumber other) {
        if (other.isZero()) {
            throw new ArithmeticException("Division by zero");
        }

        VeryLongNumber result = new VeryLongNumber("0");
        VeryLongNumber remainder = new VeryLongNumber(this.digits);

        while (!remainder.isZero() && !remainder.isLessThan(other)) {
            VeryLongNumber temp = new VeryLongNumber("1");
            VeryLongNumber product = new VeryLongNumber(other.digits);

            while (!remainder.isLessThan(product.multiply(temp))) {
                temp = temp.add(new VeryLongNumber("1"));
            }

            temp = temp.subtract(new VeryLongNumber("1"));
            result = result.add(temp);
            remainder = remainder.subtract(product.multiply(temp));
        }

        return result;
    }

    private boolean isZero() {
        for (int digit : this.digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isLessThan(VeryLongNumber other) {
        if (this.digits.size() < other.digits.size()) {
            return true;
        } else if (this.digits.size() > other.digits.size()) {
            return false;
        }

        for (int i = this.digits.size() - 1; i >= 0; i--) {
            if (this.digits.get(i) < other.digits.get(i)) {
                return true;
            } else if (this.digits.get(i) > other.digits.get(i)) {
                return false;
            }
        }

        return false;
    }

    public VeryLongNumber power(int exponent) {
        // Implementation of exponentiation
        // ...
        VeryLongNumber result = this;
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    @Override
    public String toString() {
        Collections.reverse(digits);
        StringBuilder result = new StringBuilder();
        for (Integer digit : digits) {
            result.append(digit);
        }
        return result.toString();
    }
}


