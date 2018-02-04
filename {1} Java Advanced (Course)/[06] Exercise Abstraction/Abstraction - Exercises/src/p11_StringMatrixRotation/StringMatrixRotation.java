package p11_StringMatrixRotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringMatrixRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int degrees = Integer.parseInt(reader.readLine().split("[\\(\\)]")[1]) % 360;

        List<char[]> matrix = new ArrayList<>();

        fillMatrix(reader, matrix);

        switch (degrees) {
            case 90:
                rotate90Degree(matrix);
                break;

            case 180:
                rotate180Degree(matrix);
                break;

            case 270:
                rotate270Degree(matrix);
                break;

            case 0:
                rorate0Degree(matrix);
                break;
        }
    }

    private static void rotate270Degree(List<char[]> matrix) {
        int maxLength = LongestElement(matrix);

        for (int i = maxLength - 1; i >= 0; i--) {

            for (int j = 0; j < matrix.size(); j++) {
                try{
                    System.out.print(matrix.get(j)[i]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }

    private static void rotate90Degree(List<char[]> matrix) {
        Collections.reverse(matrix);

        int maxLength = LongestElement(matrix);

        for (int i = 0; i < maxLength; i++) {

            for (int j = 0; j < matrix.size(); j++) {
                try{
                    System.out.print(matrix.get(j)[i]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }

    private static int LongestElement(List<char[]> matrix) {
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.size(); i++) {
            StringBuilder currentLine = new StringBuilder();
            charsToString(matrix, i, currentLine);


            if(maxLength < currentLine.length()) {
                maxLength = currentLine.length();
            }
        }

        return  maxLength;
    }

    private static void rotate180Degree(List<char[]> matrix) {
        Collections.reverse(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            StringBuilder currentLine = new StringBuilder();
            charsToString(matrix, i, currentLine);
            currentLine.reverse();

            System.out.println(currentLine);
        }
    }

    private static void rorate0Degree(List<char[]> matrix) {
        for (char[] line : matrix) {
            System.out.println(line);
        }
    }

    private static void charsToString(List<char[]> matrix, int i, StringBuilder currentLine) {
        for (int j = 0; j < matrix.get(i).length; j++) {
            currentLine.append(matrix.get(i)[j]);
        }
    }

    private static void fillMatrix(BufferedReader reader, List<char[]> matrix) throws IOException {
        while (true) {
            String input = reader.readLine();

            if(input.equalsIgnoreCase("end")) {
                break;
            }

            matrix.add(input.toCharArray());
        }
    }
}
