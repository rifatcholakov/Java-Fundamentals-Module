package p07_CollectTheCoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectTheCoins {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[4][];

        fillMatrix(reader, matrix);

        char[] movementCommands = reader.readLine().toCharArray();

        int collectedCoins = 0;
        int hitWalls = 0;

        int row = 0, column = 0;

        char currentCell = matrix[0][0];

        for (int i = 0; i < movementCommands.length; i++) {

            try {

                switch (Character.toLowerCase(movementCommands[i])) {
                    case 'v':
                        currentCell = matrix[row + 1][column];
                        row++;

                        if(currentCell == '$')
                            collectedCoins++;
                        break;
                    case '^':
                        currentCell = matrix[row - 1][column];
                        row--;

                        if(currentCell == '$')
                            collectedCoins++;
                        break;
                    case '>':
                        currentCell = matrix[row][column + 1];
                        column++;

                        if(currentCell == '$')
                            collectedCoins++;
                        break;
                    case '<':
                        currentCell = matrix[row][column - 1];
                        column--;

                        if(currentCell == '$')
                            collectedCoins++;
                        break;
                }

            } catch (IndexOutOfBoundsException e) {
                hitWalls++;
            }

        }

        print(collectedCoins, hitWalls);
    }

    private static void print(int collectedCoins, int hitWalls) {
        System.out.println("Coins = " + collectedCoins);
        System.out.println("Walls = " + hitWalls);
    }

    private static void fillMatrix(BufferedReader reader, char[][] matrix) throws IOException {
        for (int i = 0; i < 4; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }
    }
}
