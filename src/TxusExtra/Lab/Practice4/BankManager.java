package TxusExtra.Lab.Practice4;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class BankManager: class for testing the classes Bank and Account.
 * Uses menus for allowing the user checking and using with that classes.
 *
 * @author PRG
 * @version Academic year 2014/15
 */

public class BankManager {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in).useLocale(Locale.US);
        Bank bank = new Bank();
        Account account = null, temporaryAccount = null;
        int op, numOfAccount;
        double amount;
        String path;

        do {
            op = menu(kbd);

            switch (op) {

                case 1: // Create a new account
                    do {
                        numOfAccount = getNumOfAccount(kbd);
                        temporaryAccount = bank.getAccount(numOfAccount);
                        if (temporaryAccount != null)
                            System.out.println("\n***ERROR***: Existing account " + numOfAccount + "\n");
                    } while (temporaryAccount != null);
                    amount = getAmount(kbd);
                    account = new Account(numOfAccount, amount);
                    bank.add(account);
                    System.out.println("Account information: " + account + "\n");
                    break;

                case 2: // Deposit into the currently active account
                    amount = getAmount(kbd);
                    try {
                        account.deposit(amount);
                        System.out.println("Account information: " + account + "\n");
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: No active account! Search it before selecting this option or create a new one");
                    }
                    break;

                case 3: // Withdraw from the currently active account
                    amount = getAmount(kbd);
                    try {
                        account.withdraw(amount);
                        System.out.println("Account information: " + account + "\n");
                    } catch (NoMoneyException nme) {
                        System.out.println(nme.getMessage());
                    } catch (NullPointerException npe) {
                        System.out.println("ERROR: No active account! Search it before selecting this option or create a new one");
                    }
                    break;

                case 4: // Search an account
                    numOfAccount = getNumOfAccount(kbd);
                    temporaryAccount = bank.getAccount(numOfAccount);
                    if (temporaryAccount != null) {
                        account = temporaryAccount;
                        System.out.println("Account information: " + account + "\n");
                    } else {
                        System.out.println("\n***ERROR***: Account " + numOfAccount + " not found!\n");
                    }
                    break;

                case 5: // Show the currently active account
                    try {
                        System.out.println("Account information: " + account + "\n");
                    } catch (NullPointerException e) {
                        System.out.println("ERROR: No active account! Search it before selecting this option or create a new one");
                    }
                    break;

                case 6: // Show all the accounts
                    System.out.print("\n\nALL THE ACCOUNTS: \n" + bank + "\n\n");
                    break;

                /*
                case 7: // Load bank from file
                    path = askPath(kbd);
                    Scanner sload = null;
                    try {
                        sload = new Scanner(new FileInptuStream(new File(path)));
                        bank.loadFromTextFile(sload);
                    } catch (FileNotFoundException fnfe) {
                        System.out.printf("File '%s' could not be found!\n", path);
                    } finally {
                        if (sload != null) sload.close();
                    }

                    break;


                case 8: // Save bank to file
                    path = askPath(kbd);
                    PrintWriter pw = null;
                    try {
                        pw = new PrintWriter(path);
                        bank.saveToCSVTextFile(pw);
                    } catch (FileNotFoundException fnfe) {
                        System.out.printf("File '%s' could not be found!\n", path);
                    } finally {
                        if (pw != null) pw.close();
                    }
                    break;
                */


                case 7: // Load bank from file
                    path = askPath(kbd);

                    break;


                case 8: // Save bank to file
                    path = askPath(kbd);
                    ObjectOutputStream oos = null;
                    try {
                        oos = new ObjectOutputStream(new FileOutputStream(new File(askPath(kbd))));
                        bank.saveIntoBinaryFile(oos);
                    } catch (FileNotFoundException fnfe) {
                        System.err.printf("File '%s' could not be found!\n", path);
                    } catch (IOException ioe) {
                        System.err.println(ioe.getMessage());
                    } finally {
                        try {
                            if (oos != null) oos.close();
                        } catch (IOException ioe) {
                            System.err.println(ioe.getMessage());
                        }
                    }
                    break;

                case 9: //
                    break;

                case 0: // Exit
                    System.out.println("\n\nThe End!");
            }
        } while (op != 0);
    }

    private static String askPath(Scanner kbd){
        System.out.print("Absolute path to file? ");
        return kbd.nextLine();
    }

    /**
     * Shows a menu with options on screen and allows to the user selecting one.
     *
     * @param keyboard Scanner object for reading from.
     * @return integer value corresponding to the selected option.
     */
    private static int menu(Scanner keyboard) {
        System.out.println("------------- MENU --------------");
        System.out.println(" 0) Exit");
        System.out.println(" 1) Create a new account");
        System.out.println(" 2) Deposit into the currently active account");
        System.out.println(" 3) Withdraw from the currently active account");
        System.out.println(" 4) Search an account");
        System.out.println(" 5) Show the currently active account");
        System.out.println(" 6) Show all the accounts");
        System.out.println(" 7) Load bank from file");
        System.out.println(" 8) Save bank to file");
        System.out.println("---------------------------------");
        return CorrectReading.nextInt(keyboard, "    Select an option (0 - 7): ", 0, 7);
    }

    /**
     * Reads a real value >= 0.
     *
     * @param keyboard Scanner object for reading from.
     * @return double, real value >=0.
     */
    private static double getAmount(Scanner keyboard) {
        double amount = CorrectReading.nextRealPositive(keyboard, "\nAmount: ");
        return amount;
    }

    /**
     * Reads a valid id of account (a five digit integer).
     *
     * @param keyboard Scanner object for reading from.
     * @return int, five digit integer representing the id of an account.
     */
    private static int getNumOfAccount(Scanner keyboard) {
        int numOfAccount = CorrectReading.nextInt(keyboard, "\nId of account (5 digits): ", 10000, 99999);
        return numOfAccount;
    }
}
