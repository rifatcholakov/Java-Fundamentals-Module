package p13_BlurFilter;

import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        long[][] matrix = new long[matrixSize[0]][matrixSize[1]];
        matrix = fillMatrix(matrix, matrixSize[0], matrixSize[1], scanner);

        int[] target = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = target[0] - 1; i <= target[0] + 1; i++) {
            for (int j = target[1] - 1; j <= target[1] + 1; j++) {
                if(i <0 || j < 0 || i >= matrix.length || j >= matrix[i].length) {
                    continue;
                }

                matrix[i][j] += blurAmount;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static long[][] fillMatrix(long[][] matrix, int rows, int cols, Scanner scanner) {

        for (int i = 0; i < rows ; i++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols ; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return matrix;
    }
}
