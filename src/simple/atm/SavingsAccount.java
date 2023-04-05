package simple.atm;

public class SavingsAccount extends Account{

    private float interestRate;

    public SavingsAccount(double balance, int pin, float interestRate) {
        super(balance, pin);
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        double interest = this.getBalance() * this.interestRate;
        return interest;
    }
}
