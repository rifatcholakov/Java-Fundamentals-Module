package p05_StaticIdAndInterestRate;

public class BankAccount {

    private final static  double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id = 0;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interest) {
        rate = interest;
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}