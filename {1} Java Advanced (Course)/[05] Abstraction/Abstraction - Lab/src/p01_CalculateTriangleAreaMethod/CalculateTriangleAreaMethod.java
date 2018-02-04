package p01_CalculateTriangleAreaMethod;

import java.util.Scanner;

public class CalculateTriangleAreaMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = CalculateArea(base, height);

        print(area);
    }

    private static double CalculateArea(double base, double height) {
        double area = base * height / 2;

        return area;
    }

    private static void print(double area) {
        System.out.printf("Area = %.2f", area);
    }
}
