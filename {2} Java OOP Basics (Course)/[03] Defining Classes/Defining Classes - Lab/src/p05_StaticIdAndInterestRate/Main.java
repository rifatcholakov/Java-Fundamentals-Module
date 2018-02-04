package p05_StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (true) {
            String input = reader.readLine();

            if("end".equalsIgnoreCase(input)) {
                break;
            }

            String[] inputParams = input.split("\\s+");

            String command = inputParams[0];

            switch (command) {
                case "Create":
                    create(accounts);
                    break;

                case "Deposit":
                    deposit(accounts, inputParams);
                    break;

                case "SetInterest":
                    setInterest(inputParams[1]);
                    break;

                case "GetInterest":
                    getInterest(accounts, inputParams);
                    break;
            }

        }

    }

    private static void setInterest(String inputParam) {
        BankAccount.setInterestRate(Double.parseDouble(inputParam));
    }

    private static void getInterest(HashMap<Integer, BankAccount> accounts, String[] inputParams) {
        if(accounts.containsKey(Integer.parseInt(inputParams[1]))) {
            System.out.printf("%.2f%n", accounts.get(Integer.parseInt(inputParams[1])).getInterest(Integer.parseInt(inputParams[2])));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void deposit(HashMap<Integer, BankAccount> accounts, String[] inputParams) {
        if(accounts.containsKey(Integer.parseInt(inputParams[1]))) {
            accounts.get(Integer.parseInt(inputParams[1])).deposit(Double.parseDouble(inputParams[2]));

            System.out.printf("Deposited %s to ID%d%n", inputParams[2], Integer.parseInt(inputParams[1]));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void create(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();

        accounts.put(accounts.size() + 1, account);

        System.out.printf("Account ID%d created%n", accounts.size());
    }
}