package p03_ParseTags;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder input = new StringBuilder(reader.readLine());

        while (input.toString().contains("<upcase>")) {
            int beginIndex = input.indexOf(">") + 1;
            int endIndex = input.indexOf("</upcase>");

            String modifiedText = input.substring(beginIndex, endIndex).toUpperCase();

            input.replace(input.indexOf("<upcase>"), input.indexOf("</upcase>") + "</upcase>".length(), modifiedText);
        }

        System.out.println(input);
    }
}
