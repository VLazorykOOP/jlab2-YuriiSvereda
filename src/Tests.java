
public class Tests {
    static void task1() {
        Triangle instant = new Triangle(15, 25, 20);
        try {
            instant.setAngleA(90);
            instant.setAngleB(72);
            instant.setAngleC(54);
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        System.out.println(instant.getType());
        System.out.println(instant.getHa());
        System.out.println(instant.calculateArea());
        System.out.println(instant.calculatePerimetr());
    }

    static void task2() {
        ComplexNumber a = new ComplexNumber(3, 99);
        ComplexNumber b = new ComplexNumber(37, 0);
        System.out.println(a.calculateArgument());
        System.out.println(b.calculateModule());
        System.out.println(a.add(b));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(a.divide(b));
    }

    static void task3() {
        VeryLongNumber a = new VeryLongNumber("123456");
        VeryLongNumber b = new VeryLongNumber("987");
        System.out.println(a.add(b));
        System.out.println(b.subtract(a));
        System.out.println(a.divide(b));
        System.out.println(b.multiply(a));
        System.out.println(b.power(567));

    }
}
