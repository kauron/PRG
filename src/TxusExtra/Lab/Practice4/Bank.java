package TxusExtra.Lab.Practice4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class Bank for representing a collection of accounts.
 *
 * @author PRG
 * @version Academic year 2014/15
 */
public class Bank {
    /**
     * Maximum number of accounts.
     */
    public static final int MAX_ACCOUNTS = 100;
    /**
     * Array of objects of class Account.
     */
    private Account[] accounts;
    /**
     * Current number of accounts and index of the first free cell in the array (when the array is not full).
     */
    private int numberOfAccounts;

    /**
     * Creates a bank with no accounts (the initial capacity of accounts is MAX_ACCOUNTS).
     */
    public Bank() {
        this.accounts = new Account[MAX_ACCOUNTS];
        this.numberOfAccounts = 0;
    }

    /**
     * Getter method for consulting the current number of accounts.
     *
     * @return int, current number of accounts.
     */
    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    /**
     * Adds a new account into the bank.
     * If the bank is full duplicates the capacity of the array.
     *
     * @param c Account to be added.
     */
    public void add(Account c) {
        if (numberOfAccounts >= accounts.length) duplicateCapacity();
        accounts[numberOfAccounts++] = c;
    }

    /**
     * Duplicates the capacity of the array.
     */
    private void duplicateCapacity() {
        Account[] aux = new Account[2 * accounts.length];
        for (int i = 0; i < accounts.length; i++) aux[i] = accounts[i];
        accounts = aux;
    }

    /**
     * Returns the account with the number 'n' or null if the account doesn't exist.
     *
     * @param n int number of the account.
     * @return Account, the account with number equal to 'n', null otherwise.
     */
    public Account getAccount(int n) {
        int i = 0;
        while (i < numberOfAccounts && accounts[i].getAccountId() != n) i++;
        if (i < numberOfAccounts)
            return accounts[i];
        else
            return null;
    }

    /**
     * Returns a String object with the information of all the accounts in the bank.
     * One account per line.
     *
     * @return String.
     */
    public String toString() {
        if (numberOfAccounts == 0) {
            return "Empty bank, no accounts";
        } else {
            String str = "";
            for (int i = 0; i < numberOfAccounts; i++)
                str += accounts[i] + "\n";
            return str;
        }
    }

    public void loadFromTextFile(Scanner sf) {
        loadFromCSVTextFile(sf, " ");
    }

    public void loadFromCSVTextFile(Scanner sf) {
        loadFromCSVTextFile(sf, ",");
    }

    public void loadFromCSVTextFile(Scanner sf, String mark) {
        Account account;
        int id;
        double balance;

        if (sf == null) return;

        // TODO: validate id and balance for garbage input
        int lineNumber = 0;
        while (sf.hasNextLine()) {
            lineNumber++;
            String[] linev = sf.nextLine().split(mark);

            // TODO: make it an account list and verify all accounts before adding them!
            // should we then discard already present data and interpret them as collisions instead of extra movements?
            //List<Account> accounts = new ArrayList<Account>();

            try {
                id = Integer.parseInt(linev[0]);
                balance = Double.parseDouble(linev[1]);

                if ((account = getAccount(id)) == null) {
                    add(new Account(id, balance));
                } else {
                    // TODO: make this throw a proper exception and handle the message outside this class
                    System.out.printf("Account %d already present, deposited amount (%.2f).\n", id, balance);
                    account.deposit(balance);
                }
            } catch (NumberFormatException nfe) {
                System.out.printf("Couldn't parse line %d! No accounts were added!\n", lineNumber);
            }


        }
    }

    public void saveToCSVTextFile(PrintWriter pw) {
        pw.print(this.toString());
    }

    public void saveIntoBinaryFile( ObjectOutputStream oos ){
        for (Account account: accounts) {
            try {
                oos.writeObject(account);
            } catch (IOException ioe){
                System.err.println(ioe.getMessage());
            }
        }
    }

    public void loadIntoBinaryFile( ObjectInputStream ois ){
        boolean EOF = false;
        while (!EOF){
            try{
                this.add((Account) ois.readObject());
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}

