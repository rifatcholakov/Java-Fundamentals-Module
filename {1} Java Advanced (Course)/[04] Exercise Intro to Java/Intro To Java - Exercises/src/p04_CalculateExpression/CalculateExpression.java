package p04_CalculateExpression;

import java.util.Scanner;

public class CalculateExpression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double f1 =Math.pow(((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2))), ((a + b + c) / Math.sqrt(c)));

        System.out.printf("F1 result: %.2f;", f1);

        double f2 = Math.pow((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3)), (a - b));
        System.out.printf(" F2 result: %.2f;", f2);

        double averageOfTheNumbers = (a + b + c) / 3.0;
        double averageOFTheExpressions = (f1 + f2) / 2;
        double difference = Math.abs(averageOfTheNumbers - averageOFTheExpressions);

        System.out.printf(" Diff: %.2f", difference);
    }
}
