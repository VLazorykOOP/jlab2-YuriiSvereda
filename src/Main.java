import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Java Lab 2 ");
        // write your code here
        boolean exit = false;
        while(!exit) {
            System.out.println("choose task:");
            System.out.println("1. Task1;\n2. Task2;\n3. Task3.\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Tests.task1();
                    break;
                case 2:
                    Tests.task2();
                    break;
                case 3:
                    Tests.task3();
                case -1:
                    exit = true;
                default:
                    System.out.println("there is no such option :(");
                    break;
            }
            System.out.println("========================================================================================\n\n\n\n\n");
        }
    }
}
