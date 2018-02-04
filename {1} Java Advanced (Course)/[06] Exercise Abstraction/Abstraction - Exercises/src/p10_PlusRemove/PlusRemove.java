package p10_PlusRemove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlusRemove {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<char[]> originalMatrix = new ArrayList<>();
        List<char[]> copyMatrix = new ArrayList<>();

        fillTheMatrix(reader, originalMatrix, copyMatrix);

        modifyMatrix(originalMatrix, copyMatrix);

        printModifiedMatrix(originalMatrix);

    }

    private static void printModifiedMatrix(List<char[]> originalMatrix) {
        for (char[] charArr : originalMatrix) {
            System.out.println(charArr);
        }
    }

    private static void modifyMatrix(List<char[]> originalMatrix, List<char[]> copyMatrix) {
        for (int i = 0; i < originalMatrix.size() - 2; i++) {

            for (int j = 0; j < originalMatrix.get(i).length; j++) {
                try {
                    char a = copyMatrix.get(i)[j];
                    char b = copyMatrix.get(i + 1)[j - 1];
                    char c = copyMatrix.get(i + 1)[j];
                    char d = copyMatrix.get(i + 1)[j + 1];
                    char e = copyMatrix.get(i + 2)[j];

                    if(a == b && b == c && c == d && d == e) {
                     originalMatrix.get(i)[j] = '\0';
                     originalMatrix.get(i + 1)[j - 1] = '\0';
                     originalMatrix.get(i + 1)[j] = '\0';
                     originalMatrix.get(i + 1)[j + 1] = '\0';
                     originalMatrix.get(i + 2)[j] = '\0';
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
    }

    private static void fillTheMatrix(BufferedReader reader, List<char[]> originalMatrix, List<char[]> copyMatrix) throws IOException {
        while (true) {

            String input = reader.readLine();

            if(input.equalsIgnoreCase("end")) {
                break;
            }

            originalMatrix.add(input.toCharArray());
            copyMatrix.add(input.toUpperCase().toCharArray());
        }
    }
}
