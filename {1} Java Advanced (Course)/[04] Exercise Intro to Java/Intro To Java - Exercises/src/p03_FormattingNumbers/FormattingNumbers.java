package p03_FormattingNumbers;

import java.util.Scanner;

public class FormattingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String bFormated = String.format("%.2f", b);
        String cFormated = String.format("%.3f", c);

        System.out.print("|");
        System.out.print(Integer.toHexString(a).toUpperCase());
        for (int i = 0; i < 10 - Integer.toHexString(a).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for (int i = 0; i < 10 - Integer.toBinaryString(a).length(); i++) {
            System.out.print("0");
        }
        System.out.print(Integer.toBinaryString(a));
        System.out.print("|");
        for (int i = 0; i < 10 - bFormated.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(bFormated);
        System.out.print("|");
        System.out.print(cFormated);
        for (int i = 0; i < 10 - cFormated.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|");

    }
}
