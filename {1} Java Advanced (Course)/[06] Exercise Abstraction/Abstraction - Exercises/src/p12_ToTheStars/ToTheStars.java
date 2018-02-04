package p12_ToTheStars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ToTheStars {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstStar = reader.readLine().split("\\s+");
        String[] secondStar = reader.readLine().split("\\s+");
        String[] thirdStar = reader.readLine().split("\\s+");

        double[][] starsArgs = setStarCordinates(firstStar, secondStar, thirdStar);

        String[] starNames = setStarNames(firstStar, secondStar, thirdStar);

        double[] shipCordinates = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        double shipX = shipCordinates[0];
        double shipY = shipCordinates[1];

        double movies = Double.parseDouble(reader.readLine());

        getShipLocation(starsArgs, starNames, shipX, shipY, movies);
    }

    private static double[][] setStarCordinates(String[] firstStar, String[] secondStar, String[] thirdStar) {
        double[][] starsArgs = new double[3][2];
        starsArgs[0][0] = Double.parseDouble(firstStar[1]);
        starsArgs[0][1] = Double.parseDouble(firstStar[2]);

        starsArgs[1][0] = Double.parseDouble(secondStar[1]);
        starsArgs[1][1] = Double.parseDouble(secondStar[2]);

        starsArgs[2][0] = Double.parseDouble(thirdStar[1]);
        starsArgs[2][1] = Double.parseDouble(thirdStar[2]);
        return starsArgs;
    }

    private static String[] setStarNames(String[] firstStar, String[] secondStar, String[] thirdStar) {
        String[] starNames = new String[3];
        starNames[0] = firstStar[0].toLowerCase();
        starNames[1] = secondStar[0].toLowerCase();
        starNames[2] = thirdStar[0].toLowerCase();
        return starNames;
    }

    private static void getShipLocation(double[][] starsArgs, String[] starNames, double shipX, double shipY, double movies) {
        for (int i = 0; i <= movies; i++) {
            boolean found = false;

            for (int j = 0; j < starsArgs.length; j++) {

                double starX0 = starsArgs[j][0] - 1;
                double starY0 = starsArgs[j][1] - 1;

                double starX2 = starX0 + 2;
                double starY2 = starY0 + 2;

                if(isInside(shipX, shipY, starX0, starY0, starX2, starY2)) {
                    System.out.println(starNames[j]);
                    found = true;
                    break;
                }
            }

            if(!found) {
                System.out.println("space");
            }

            shipY++;
        }
    }

    private static boolean isInside(double shipX, double shipY, double starX0, double starY0, double starX2, double starY2) {
        boolean firstcheck = (shipX >= starX0) && (shipY >= starY0);
        boolean secondCheck = (shipX <= starX2 && shipY <= starY2);
        return firstcheck && secondCheck;
    }
}
