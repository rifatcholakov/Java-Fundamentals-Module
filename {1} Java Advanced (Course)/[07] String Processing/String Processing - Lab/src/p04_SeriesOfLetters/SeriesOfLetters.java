package p04_SeriesOfLetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();

        char previousLetter = '\0';

        for (int i = 0; i < input.length; i++) {
            char currentLetter = input[i];

            if(input[i] == previousLetter) {
                input[i] = '\0';
            }

            previousLetter = currentLetter;
        }

        System.out.println(input);
    }
}
