package simple.atm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class Account implements Transactions{
    private final int accountNumber;
    private int pin;
    private double balance;

    // feature to auto increment account number
    private static int nextAccountNumber = 1001;

    public Account(double balance, int pin){
        this.balance = balance;
        this.pin = pin;

        accountNumber = getNaxtAccountNumber();
    }

    public static int getNaxtAccountNumber() {
        int accountNumber = nextAccountNumber;
        nextAccountNumber++;
        return accountNumber;
    }

    public boolean validatePin(int pin){
        if(this.pin == pin){
            return true;
        }
        System.out.println("Invalid pin");
        return false;
    }

    public int getAccountNumber(){return accountNumber;}


    @Override
    public boolean withdraw(double debitAmt) {
        if(debitAmt > this.balance){
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= debitAmt;
        Transactions.recordTransaction(debitAmt, "Debit");
        System.out.println("Please take your card and money.");
        return true;
    }

    @Override
    public boolean deposit(double creditAmt) {
        balance += creditAmt;
        Transactions.recordTransaction(creditAmt, "Credit");
        System.out.println("Deposit successful.");
        return true;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public boolean printTransactions(){
        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))){
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                content.append(currentLine).append("\n");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(content);
        return true;
    }
}
