package p01_FillTheMatrix;

import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String matrixPatternType = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if(matrixPatternType.equals("A")){
            patternA(matrixSize, matrix);
        } else {
            patternB(matrixSize, matrix);
        }


        print(matrixSize, matrix);
    }

    private static void patternB(int matrixSize, int[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {
                if(j == 0) {
                    matrix[i][j] = i + 1;
                } else {
                    if(j > 1) {

                        if(j == 2) {
                            matrix[i][j] = matrix[i][j - 1] + matrix[i][j - 2] + i;
                        } else {
                            matrix[i][j] = matrix[i][j - 1] + matrix[i][j - 2] - matrix[i][j - 3];
                        }
                    } else {
                        matrix[i][j] = 2* matrixSize - i;
                    }
                }
            }
        }
    }

    private static void patternA(int matrixSize, int[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {
            int currentRow = i + 1;

            for (int j = 0; j < matrixSize; j++) {
                if(j == 0) {
                    matrix[i][j] = currentRow;
                } else {
                    matrix[i][j] = matrix[i][j - 1] + matrixSize;
                }
            }
        }
    }

    private static void print(int matrixSize, int[][] matrix) {
        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
