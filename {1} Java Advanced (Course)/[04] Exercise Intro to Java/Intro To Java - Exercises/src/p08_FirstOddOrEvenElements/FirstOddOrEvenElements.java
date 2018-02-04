package p08_FirstOddOrEvenElements;

import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEvenElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[] command = scanner.nextLine().split("\\s+");

        boolean even = command[2].equals("even") ? true : false;

        for (int i = 0, count = 0; i < elements.length; i++) {

            if(count == Integer.parseInt(command[1])){
                break;
            }

            if(even) {
                if (elements[i] % 2 == 0) {
                    System.out.print(elements[i] + " ");

                    count++;
                }
            } else {
                if (elements[i] % 2 != 0) {
                    System.out.print(elements[i] + " ");

                    count++;
                }
            }
        }                
    }
}
