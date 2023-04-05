package simple.atm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Transactions {

    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("yyyy:MM:dd - HH:mm:ss");
    String dateTimeFormat = dateTime.format(DateFormat);

    boolean withdraw(double debitAmt);
    boolean deposit(double creditAmt);
    double getBalance();

    static boolean recordTransaction(double transactionAmount, String transactionType){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true)))
        {
            writer.write(
                    (transactionType == "Credit") ?
                            "\n\tAmount credited: $"
                            + transactionAmount
                            + "\tDate: " + dateTimeFormat
                    :
                            "\n\tAmount debited: $"
                            + transactionAmount
                            + "\tDate: " + dateTimeFormat
            );
        }catch (IOException e){
            System.out.println("Error occured writing to file");
            e.printStackTrace();
        }
        return true;

    }
}
