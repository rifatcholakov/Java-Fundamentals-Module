package p05_MaximalSum;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixProperties = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        int[][] matrix = new int[rows][columns];

        fillMatrix(scanner, rows, matrix);

        int sum = Integer.MIN_VALUE;

        int[][] elements = new int[3][3];

        sum = findMaxSum(rows, columns, matrix, sum, elements);

        print(sum, elements);

    }

    private static void print(int sum, int[][] elements) {
        System.out.println("Sum = " + sum);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(elements[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static int findMaxSum(int rows, int columns, int[][] matrix, int sum, int[][] elements) {
        for (int i = 0; i < rows - 2; i++) {

            for (int j = 0; j < columns - 2; j++) {
                int firstRow = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                int secondRow = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2];
                int thirdRow = matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                int currentSum = firstRow + secondRow + thirdRow;

                if(currentSum > sum) {
                    sum = currentSum;

                    fillElements(matrix, elements, i, j);
                }

            }
        }
        return sum;
    }

    private static void fillElements(int[][] matrix, int[][] elements, int i, int j) {
        for (int k = 0; k < 3; k++) {

            for (int l = 0; l < 3; l++) {
                elements[k][l] = matrix[i + k][j + l];
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = input;
        }
    }
}
