package Topic3.Lab4;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Bank for representing a collection of accounts.
 * @author PRG 
 * @version Academic year 2014/15
 */
public class Bank implements Serializable
{
    /** Array of objects of class Account. */
    private Account[] accounts;
    /** Current number of accounts and index of the first free cell in the array (when the array is not full). */
    private int numberOfAccounts;
    /** Maximum number of accounts. */
    public static final int MAX_ACCOUNTS = 100;

    /**
     * Creates a bank with no accounts (the initial capacity of accounts is MAX_ACCOUNTS).
     */
    public Bank()
    {
        this.accounts = new Account[MAX_ACCOUNTS];
        this.numberOfAccounts = 0;
    }

    /**
     * Getter method for consulting the current number of accounts.
     * @return int, current number of accounts.
     */
    public int getNumberOfAccounts() { return numberOfAccounts; }

    /**
     * Adds a new account into the bank. 
     * If the bank is full duplicates the capacity of the array.
     * @param c Account to be added.
     */
    public void add( Account c )
    {
        if (getAccount(c.getAccountId()) == null) {
            if (numberOfAccounts >= accounts.length) duplicateCapacity();
            accounts[numberOfAccounts++] = c;
        } else {
            System.out.println("The account " + c.toString() + " already exists.");
        }
    }

    /**
     * Duplicates the capacity of the array.
     */
    private void duplicateCapacity()
    {
        Account[] aux = new Account[2*accounts.length];
        System.arraycopy(accounts, 0, aux, 0, accounts.length);
        accounts = aux;
    }

    /**
     * Returns the account with the number 'n' or null if the account doesn't exist.
     * @param n int number of the account.
     * @return Account, the account with number equal to 'n', null otherwise.
     */
    public Account getAccount( int n )
    {
        int i = 0;
        while ( i < numberOfAccounts && accounts[i].getAccountId() != n ) i++;
        if ( i < numberOfAccounts )
            return accounts[i];
        else
            return null;
    }

    private Account getAccountByPosition ( int n ) {
        return accounts[n];
    }

    /**
     * Returns a String object with the information of all the accounts in the bank.
     * One account per line.
     * @return String.
     */
    public String toString()
    {
        if ( numberOfAccounts == 0 ) {
            return "Empty bank, no accounts";
        } else {
            String str = "";
            for ( int i=0; i < numberOfAccounts; i++ ) str += accounts[i] + "\n"; 
            return str;
        }        
    }

    public void loadFromTextFile( Scanner sf ) {
        while ( sf.hasNext() ) {
            try {
                int id = sf.nextInt();
                double balance = sf.nextDouble();
                if (id >= 10000 && id <= 99999 && balance >= 0)
                    this.add(new Account(id, balance));
            } catch ( InputMismatchException ime ) {
                System.out.println("ERROR: The file didn't contain valid accounting data.");
            }
        }
    }

    public void saveIntoTextFile( PrintWriter pw ){
        //Activity10
        //for( int i = 0; i < numberOfAccounts; i++) pw.println(accounts[i].toString());

        //Activity11
        if (this.numberOfAccounts != 0)
            pw.print(this.toString());
    }

    public void loadFromBinaryFile (ObjectInputStream ois) throws ClassNotFoundException, IOException{
        //noinspection InfiniteLoopStatement
        while (true) {
            Object o = ois.readObject();
            if (o instanceof Account)
                this.add((Account) o);
        }
    }


    public void saveIntoBinaryFile (ObjectOutputStream oos) throws IOException{
        for (int i = 0; i < numberOfAccounts; i++){
            oos.writeObject(accounts[i]);
        }
    }

    public void loadBinary ( ObjectInputStream ios ) throws IOException, ClassNotFoundException {
        Object o = ios.readObject();
        if (o instanceof Bank) {
            Bank b = (Bank) o;
            for ( int i = 0; i < b.getNumberOfAccounts(); i++)
                this.add(b.getAccountByPosition(i));
        }
    }

    public void saveBinary ( ObjectOutputStream oos ) throws IOException {
        oos.writeObject(this);
    }
}
