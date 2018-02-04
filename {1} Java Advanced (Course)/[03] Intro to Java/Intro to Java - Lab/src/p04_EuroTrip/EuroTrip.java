package p04_EuroTrip;

import java.util.Scanner;
import java.math.BigDecimal;

public class EuroTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();

        double priceInBGN = quantity * 1.2;
        BigDecimal priceInMarks = new BigDecimal(priceInBGN).multiply(new BigDecimal(4210500000000.0));

        System.out.printf("%.2f marks", priceInMarks);
    }
}
