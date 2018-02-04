package p05_Greeting;

import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        String firstName = scaner.nextLine();
        String lastName = scaner.nextLine();

        if(firstName.isEmpty()) {
            firstName = "*****";
        }

        if(lastName.isEmpty()) {
            lastName = "*****";
        }

        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
