package p12_VehiclePark;

import java.util.ArrayList;
import java.util.Scanner;

public class VehiclePark {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allVehiclesInThePark = scanner.nextLine().split("\\s+");

        ArrayList<String> allVehiclesList = new ArrayList<>();

        for (int i = 0; i < allVehiclesInThePark.length; i++) {
            allVehiclesList.add(allVehiclesInThePark[i]);
        }

        String request = scanner.nextLine();

        int vehiclesSold = 0;

        while (!request.equals("End of customers!")) {
            String vehicleType = request.split("\\s+")[0];
            String numberOfSeats = request.split("\\s+")[2];

            StringBuilder currentVehicle = new StringBuilder();
            currentVehicle.append(vehicleType.toLowerCase().charAt(0));
            currentVehicle.append(numberOfSeats);

            if (allVehiclesList.contains(currentVehicle.toString())) {
                allVehiclesList.remove(currentVehicle.toString());

                int price = currentVehicle.charAt(0) * Integer.parseInt(numberOfSeats);

                System.out.println("Yes, sold for " + price + "$");

                vehiclesSold++;
            } else {
                System.out.println("No");
            }

            request = scanner.nextLine();
        }

        System.out.println("Vehicles left: " + String.join(", ", allVehiclesList));

        System.out.println("Vehicles sold: " + vehiclesSold);
    }
}