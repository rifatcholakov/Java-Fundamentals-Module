package p02_ReadInput;

import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.next();
        String secondString = scanner.next();

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber + thirdNumber;

        String thirdString = scanner.next();

        System.out.println(firstString + " " + secondString + " " + thirdString + " " + sum);
    }
}
