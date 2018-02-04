package p04_MaximumSumOf2x2Submatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixProperties = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        int[][] matrix = new int[rows][columns];

        fillMatrix(scanner, rows, columns, matrix);

        ArrayList<Integer> elements = new ArrayList<>();

        int sum = findBigestSumOf2x2Elements(rows, columns, matrix, elements);

        print(elements, sum);

    }

    private static void print(ArrayList<Integer> elements, int sum) {
        System.out.println(elements.get(0) + " " + elements.get(1));
        System.out.println(elements.get(2) + " " + elements.get(3));
        System.out.println(sum);
    }

    private static int findBigestSumOf2x2Elements(int rows, int columns, int[][] matrix, ArrayList<Integer> elements) {
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < rows - 1; i++) {

            for (int j = 0; j < columns - 1; j++) {
                int currentElementSum = matrix[i][j] + matrix[i][j + 1] + matrix[i+ 1][j] + matrix[i + 1][j + 1];

                if(currentElementSum > sum) {
                    sum = currentElementSum;

                    elements.clear();

                    elements.add(matrix[i][j]);
                    elements.add(matrix[i][j + 1]);
                    elements.add(matrix[i+ 1][j]);
                    elements.add(matrix[i + 1][j + 1]);
                }
            }
        }

        return sum;
    }

    private static void fillMatrix(Scanner scanner, int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input[j];
            }
        }
    }
}
