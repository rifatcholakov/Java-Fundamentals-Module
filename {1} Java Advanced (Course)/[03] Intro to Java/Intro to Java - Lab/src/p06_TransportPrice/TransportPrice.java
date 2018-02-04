package p06_TransportPrice;

import java.util.Scanner;

public class TransportPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = scanner.nextInt();
        String time = scanner.next();

        double cost = 0;

        if(kilometers < 20) {
            switch (time) {
                case "day":
                    cost = 0.7 + (0.79 * kilometers);
                    break;

                case "night":
                    cost = 0.7 + (0.9 * kilometers);
                    break;
            }
        } else if (kilometers >= 20 && kilometers < 100) {
            cost = 0.09 * kilometers;
        } else {
            cost = 0.06 * kilometers;
        }

        System.out.printf("%.2f", cost);
    }
}
