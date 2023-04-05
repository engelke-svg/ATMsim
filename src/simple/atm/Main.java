package simple.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int pinNum;
        int userOption = 0;

        //SavingsAccount account1 = new SavingsAccount(5000, 1423, .034f);
        CheckingAccount account1 = new CheckingAccount(5000, 1423, 2);

        Scanner scanner = new Scanner(System.in);

        account1.printTransactions();

        ATM atm = new ATM();

        // zeigt den Inhalt der transactions.txt
        pinNum = scanner.nextInt();

        if(account1.validatePin(pinNum)){
            //System.out.println("Success!!");
            System.out.println();
            do {
                atm.menu();
                userOption = scanner.nextInt();
                switch ( userOption ){
                    case 1:
                        atm.withdrawMenu();
                        double withdrawAmount = scanner.nextDouble();
                        account1.withdraw(withdrawAmount + account1.getFee() );
                        break;

                    case 2:
                        atm.depositMenu();
                        double depositAmount = scanner.nextDouble();
                        account1.deposit(depositAmount);
                        break;

                    case 3:
                        atm.balanceMenu(account1.getBalance());
                        // System.out.printf("\nThe interest is $%.2f",account1.calculateInterest()); // savings account
                        break;

                    case 4:
                        atm.exitMenu();
                        break;

                    default:
                        atm.invalidMessageMenu();
                        break;
                }

            }while(userOption != 4);
        }



/*
        System.out.println(account1.getBalance());
        account1.deposit(700);
        System.out.println(account1.getBalance());
        account1.withdraw(2000);
        System.out.println(account1.getBalance());
*/



    }

}


