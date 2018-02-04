package p04_2x2SquaresInMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class TwoXTwoSquaresInMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixProperties = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        String[][] matrix = new String[rows][columns];

        fillMatrix(scanner, rows, matrix);

        int count = countEqualsChar(rows, columns, matrix);

        System.out.println(count);
    }

    private static int countEqualsChar(int rows, int columns, String[][] matrix) {
        int count = 0;

        for (int i = 0; i < rows - 1; i++) {

            for (int j = 0; j < columns - 1; j++) {
                String mainChar = matrix[i][j];

                if(mainChar.equals(matrix[i][j + 1]) &&(mainChar.equals(matrix[i + 1][j])) &&(mainChar.equals(matrix[i + 1][j + 1])))
                    count++;
            }
        }
        return count;
    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            matrix[i] = input;
        }
    }
}
