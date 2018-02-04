package p05_VowelCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();

        Pattern pattern = Pattern.compile("[aeiouy]");
        Matcher matcher = pattern.matcher(input);

        int counter = 0;

        while (matcher.find()) {
            counter++;
        }

        System.out.println("Vowels: " + counter);
    }
}
