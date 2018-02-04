package p03_SumMatrixElements;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumMatrixElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixProperties = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        int sum  = findSumOfMatrixElement(scanner, rows);

        print(rows, columns, sum);
    }

    private static void print(int rows, int columns, int sum) {
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }

    private static int findSumOfMatrixElement(Scanner scanner, int rows) {
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            sum += IntStream.of(row).sum();
        }

        return sum;
    }
}
