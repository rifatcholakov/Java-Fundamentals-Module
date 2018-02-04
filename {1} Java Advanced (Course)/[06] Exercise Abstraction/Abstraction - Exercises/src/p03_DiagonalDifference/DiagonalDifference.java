package p03_DiagonalDifference;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix(scanner, matrixSize, matrix);

        int primaryDiagonalSum = 0;
        int secondaryDiagonlSum = 0;

        for (int i = 0; i < matrixSize; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonlSum += matrix[i][matrixSize - 1 - i];
        }

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonlSum));
    }

    private static void fillMatrix(Scanner scanner, int matrixSize, int[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = input;
        }
    }
}
