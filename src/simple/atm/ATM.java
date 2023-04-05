package simple.atm;

public class ATM {
    public ATM(){
        System.out.println("Enter your PIN: ");
    }

    public void menu(){
        System.out.println();
        System.out.printf("\n1. Withdraw");
        System.out.printf("\n2. Deposit");
        System.out.printf("\n3. Balance inquiry");
        System.out.printf("\n4. Exit");
        System.out.println();
    }

    public void withdrawMenu() {
        System.out.println("Enter an amount to withdraw: ");
    }
    public void depositMenu() {
        System.out.println("Enter an amount to deposit: ");
    }
    public void balanceMenu(double balance) {
        System.out.printf("The balance is $%.2f:", balance);
    }
    public void invalidMessageMenu() {
        System.out.println("Invalid option. Try again.");
    }
    public void exitMenu(){
        System.out.println("\nThanks for banking with us.");
    }
}
