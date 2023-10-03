public class ComplexNumber {
    private double real;
    private double imaginary;
    public ComplexNumber(){
        this.real = 0;
        this.imaginary = 0;
    }
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public double calculateModule(){
        return Math.sqrt(real*real + imaginary*imaginary);
    }
    public double calculateArgument(){
        return Math.atan2(imaginary, real);
    }
    public ComplexNumber add(ComplexNumber other){
        ComplexNumber newNumdber = new ComplexNumber();
        newNumdber.real = this.real + other.real;
        newNumdber.imaginary = this.imaginary + other.imaginary;
        return  newNumdber;
    }
    public ComplexNumber subtract(ComplexNumber other){
        ComplexNumber newNumdber = new ComplexNumber();
        newNumdber.real = this.real - other.real;
        newNumdber.imaginary = this.imaginary - other.imaginary;
        return  newNumdber;
    }
    public ComplexNumber multiply(ComplexNumber other){
        ComplexNumber newNumdber = new ComplexNumber();
        newNumdber.real = this.real*other.real - this.imaginary*other.imaginary;
        newNumdber.imaginary = this.real*other.imaginary + other.real*this.imaginary;
        return newNumdber;
    }
    public ComplexNumber divide(ComplexNumber other){
        ComplexNumber newNumdber = new ComplexNumber();
        newNumdber.real = (this.real*other.real + this.imaginary*other.imaginary)/
                (Math.pow(other.real, 2) + Math.pow(other.imaginary, 2));
        newNumdber.imaginary = -((this.real*other.imaginary - this.imaginary*other.real) /
                ((Math.pow(other.real, 2) + Math.pow(other.imaginary, 2))));
        return newNumdber;
    }
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }
    @Override
    public String toString() {
        if (imaginary < 0) {
            return real + " - " + (-imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}
