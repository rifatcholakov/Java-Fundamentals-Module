package p09_TerroristsWin;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        char[] inputCharacters = new char[input.length()];

        Pattern pattern = Pattern.compile("(\\|.*?\\|)");
        Matcher match = pattern.matcher(input);

        List<Integer> pipeIndexes = new ArrayList<>();

        while (match.find()) {
            String group = match.group();
            String currentMatch = group.substring(1, group.length() - 1);

            int power = 0;

            power = getPower(currentMatch, power);

            input = replacePipes(input, pipeIndexes);

            inputCharacters = input.toCharArray();

            replaceCharacters(inputCharacters, pipeIndexes, power);

            input = setInput(inputCharacters);

            pipeIndexes.clear();
        }

        System.out.println(input);
    }

    private static String replacePipes(String input, List<Integer> pipeIndexes) {
        int pipeIndex = input.indexOf("|");
        pipeIndexes.add(pipeIndex);
        input = input.replaceFirst("\\|", ".");

        pipeIndex = input.indexOf("|");
        pipeIndexes.add(pipeIndex);
        input = input.replaceFirst("\\|", ".");
        return input;
    }

    private static String setInput(char[] inputCharacters) {
        String input;
        input = "";

        for (int i = 0; i < inputCharacters.length; i++) {
            input += inputCharacters[i];
        }
        return input;
    }

    private static void replaceCharacters(char[] inputCharacters, List<Integer> pipeIndexes, int power) {
        int index = pipeIndexes.get(0) - power;
        int endIndex = pipeIndexes.get(1) + power;

        if(index < 0) {
            index = 0;
        }

        if(endIndex >= inputCharacters.length) {
            endIndex = inputCharacters.length - 1;
        }

        while (index <= endIndex) {
            inputCharacters[index] = '.';

            index++;
        }
    }

    private static int getPower(String currentMatch, int power) {
        for (int i = 0; i < currentMatch.length(); i++) {
            int asciiCode = currentMatch.toCharArray()[i];
            String lastDigit = (asciiCode + "").substring((asciiCode + "").length() - 1);

            power += Integer.parseInt(lastDigit);
        }

        power = power % 10;

        return power;
    }

}