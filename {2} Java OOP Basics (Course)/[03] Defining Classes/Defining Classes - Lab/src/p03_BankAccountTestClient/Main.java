package p03_BankAccountTestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String command = reader.readLine();

        while (!"end".equalsIgnoreCase(command)) {
            String[] cmdArgs = command.split("\\s+");

            String cmdType = cmdArgs[0];
            switch (cmdType) {
                case "Create":
                    execCreate(cmdArgs, accounts);
                    break;
                case "Deposit":
                    execDeposit(cmdArgs, accounts);
                    break;
                case "Withdraw":
                    execWithdraw(cmdArgs, accounts);
                    break;
                case "Print":
                    execPrint(cmdArgs, accounts);
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void execPrint(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);

        if(accounts.containsKey(id)) {
            System.out.printf("Account ID%d, balance %.2f%n", id, accounts.get(id).getBalance());
        } else {
            System.out.println("Account does not exist");
        }

    }

    private static void execWithdraw(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);

        if(accounts.containsKey(id)) {
            if(accounts.get(id).getBalance() >= Double.valueOf(cmdArgs[2])) {
                double currentBalance = accounts.get(id).getBalance();
                currentBalance -= Double.valueOf(cmdArgs[2]);
                accounts.get(id).setBalance(currentBalance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);

        if(accounts.containsKey(id)) {
            double currentBalance = accounts.get(id).getBalance();
            currentBalance += Double.valueOf(cmdArgs[2]);
            accounts.get(id).setBalance(currentBalance);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void execCreate(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);

        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}