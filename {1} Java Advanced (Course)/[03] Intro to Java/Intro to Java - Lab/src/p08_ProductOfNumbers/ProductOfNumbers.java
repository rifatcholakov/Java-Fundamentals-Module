package p08_ProductOfNumbers;

import java.util.Scanner;
import java.math.BigInteger;

public class ProductOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger result = BigInteger.valueOf(1);

        for (int i = n; i <= m; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println("product[" + n + ".." + m + "] = " + result);
    }
}
