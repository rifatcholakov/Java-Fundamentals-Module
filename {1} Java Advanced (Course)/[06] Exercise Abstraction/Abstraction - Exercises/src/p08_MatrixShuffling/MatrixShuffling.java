package p08_MatrixShuffling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixProperties = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixProperties[0];
        int columns = matrixProperties[1];

        String[][] matrix = new String[rows][columns];

        fillMatrix(reader, rows, matrix);

        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] inputParams = input.split("\\s+");

            if(inputParams.length != 5 || !(inputParams[0].equals("swap"))) {
                System.out.println("Invalid input!");

                input = reader.readLine();
                continue;
            }

            try {
                int row1 = Integer.parseInt(inputParams[1]);
                int col1 = Integer.parseInt(inputParams[2]);
                int row2 = Integer.parseInt(inputParams[3]);
                int col2 = Integer.parseInt(inputParams[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Invalid input!");

                input = reader.readLine();
                continue;
            }

            print(rows, columns, matrix);

            input = reader.readLine();
        }

    }

    private static void print(int rows, int columns, String[][] matrix) {
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static void fillMatrix(BufferedReader reader, int rows, String[][] matrix) throws IOException {
        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().split("\\s+");
        }
    }
}
