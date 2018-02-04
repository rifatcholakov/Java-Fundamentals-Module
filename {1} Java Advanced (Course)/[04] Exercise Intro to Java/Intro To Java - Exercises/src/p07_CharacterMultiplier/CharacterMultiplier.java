package p07_CharacterMultiplier;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int length = 0;
        String remaingString = "";

        if(input[0].length() < input[1].length()){
            length = input[0].length();

            remaingString = input[1];
        } else {
            length = input[1].length();

            remaingString = input[0];
        }

        char[] firstArr = input[0].toCharArray();
        char[] secondArr = input[1].toCharArray();

        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += firstArr[i] * secondArr[i];
        }

        remaingString = remaingString.substring(length);

        char[] remindingChars = remaingString.toCharArray();

        for (int i = 0; i < remindingChars.length; i++) {
            sum += remindingChars[i];
        }

        System.out.println(sum);
    }
}
