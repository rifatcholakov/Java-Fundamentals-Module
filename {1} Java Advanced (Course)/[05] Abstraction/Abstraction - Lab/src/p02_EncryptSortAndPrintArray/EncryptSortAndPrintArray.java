package p02_EncryptSortAndPrintArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EncryptSortAndPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Integer> encriptedWords = new ArrayList<>();

        Encrypt(scanner, n, encriptedWords);

        Collections.sort(encriptedWords);

        print(encriptedWords);
    }

    private static void print(ArrayList<Integer> encriptedWords) {
        for (int i = 0; i < encriptedWords.size(); i++) {
            System.out.println(encriptedWords.get(i));
        }
    }

    private static void Encrypt(Scanner scanner, int n, ArrayList<Integer> encriptedWords) {
        for (int i = 0; i < n; i++) {
            char[] input = scanner.nextLine().toCharArray();

            int wordLength = input.length;

            int charactersSum = 0;

            for (int j = 0; j < input.length; j++) {
                char character = input[j];

                if(isVowel(character)) {
                    charactersSum += character * wordLength;
                } else {
                    charactersSum += character / wordLength;
                }
            }

            encriptedWords.add(charactersSum);
        }
    }

    private static boolean isVowel(char character) {
        boolean vowel = false;

        character = Character.toLowerCase(character);

        if(character == 'a' || character == 'u' || character == 'o' || character == 'e' || character == 'i') {
            vowel = true;
        }

        return vowel;
    }
}
