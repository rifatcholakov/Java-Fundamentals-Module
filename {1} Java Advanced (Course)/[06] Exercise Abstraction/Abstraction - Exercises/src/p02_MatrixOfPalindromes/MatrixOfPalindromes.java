package p02_MatrixOfPalindromes;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixProperties = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        String[][] matrix = new String[rows][columns];

        fillMatrix(rows, columns, matrix);

        print(rows, columns, matrix);
    }

    private static void fillMatrix(int rows, int columns, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            char firstAndLastChar = (char)(97 + i);
            for (int j = 0; j < columns; j++) {
                char middleChar = (char)(97 + j + i);

                matrix[i][j] = Character.toString(firstAndLastChar) + middleChar + firstAndLastChar + " ";
            }
        }
    }

    private static void print(int rows, int columns, String[][] matrix) {
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }
}
