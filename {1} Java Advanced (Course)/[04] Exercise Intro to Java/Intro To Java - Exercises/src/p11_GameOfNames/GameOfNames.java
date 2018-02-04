package p11_GameOfNames;

import java.util.Scanner;

public class GameOfNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPlayers = Integer.parseInt(scanner.nextLine());

        int currentPlayerScore = Integer.MIN_VALUE;
        String currentPlayerName = "";

        for (int i = 0; i < countOfPlayers; i++) {
            String playerName = scanner.nextLine();
            int playerScore = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < playerName.length(); j++) {
                if(playerName.charAt(j) % 2 == 0) {
                    playerScore += playerName.charAt(j);
                } else {
                    playerScore -= playerName.charAt(j);
                }
            }

            if(currentPlayerScore < playerScore) {
                currentPlayerScore = playerScore;
                currentPlayerName = playerName;
            }
        }

        System.out.printf("The winner is %s - %d points", currentPlayerName, currentPlayerScore );
    }
}
