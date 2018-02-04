package p01_RectangleArea;

import java.util.Scanner;

public class RectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double result = a * b;

        System.out.printf("%.2f", result);
    }
}
