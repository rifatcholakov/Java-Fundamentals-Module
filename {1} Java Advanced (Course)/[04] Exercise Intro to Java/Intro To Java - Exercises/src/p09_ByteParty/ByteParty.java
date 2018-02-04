package p09_ByteParty;

import java.util.Arrays;
import java.util.Scanner;

public class ByteParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] integers = new int[n];

        for (int i = 0; i < n; i++) {
            int integer = Integer.parseInt(scanner.nextLine());

            integers[i] = integer;
        }

        String input = scanner.nextLine();

        while (!input.equals("party over")) {
            int flipType = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray()[0];
            int position = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray()[1];

            switch (flipType) {

                case -1:
                    for (int i = 0; i < n; i++) {
                        integers[i] ^= (1 << position);
                    }
                    break;

                case 0:
                    for (int i = 0; i < n; i++) {
                        integers[i] &= ~(1 << position);
                    }

                    break;

                case 1:
                    for (int i = 0; i < n; i++) {
                        integers[i] |= (1 << position);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(integers[i]);
        }
    }
}
