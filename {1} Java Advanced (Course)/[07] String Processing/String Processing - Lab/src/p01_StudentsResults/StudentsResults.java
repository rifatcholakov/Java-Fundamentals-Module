package p01_StudentsResults;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsResults {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[\\s,-]+");

        String name = input[0];
        double javaAdv = Double.parseDouble(input[1]);
        double javaOop = Double.parseDouble(input[2]);
        double javaAdvOop = Double.parseDouble(input[3]);
        double average = (javaAdv + javaOop + javaAdvOop) / 3.0;

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, javaAdv, javaOop, javaAdvOop, average));
    }
}
