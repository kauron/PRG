package Topic3.Lab4;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;
import java.util.Locale; 

/**
 * Class BankManager: class for testing the classes Bank and Account.
 * Uses menus for allowing the user checking and using with that classes.
 * @author PRG 
 * @version Academic year 2014/15
 */

public class BankManager
{
    public static void main(String[] args)
    {
        Scanner  keyboard = new Scanner(System.in).useLocale(Locale.US);        
        Bank bank = new Bank();              
        Account account = null, temporaryAccount;
        int op, numOfAccount;
        double amount;

        do {
            op = menu( keyboard );

            switch( op ) {

                case 1: // Create a new account
                    do {
                        numOfAccount = getNumOfAccount( keyboard );
                        temporaryAccount = bank.getAccount( numOfAccount );
                        if ( temporaryAccount != null )
                            System.out.println("\n***ERROR***: Existing account " + numOfAccount + "\n" );
                    } while( temporaryAccount != null );
                    amount = getAmount( keyboard );
                    account = new Account( numOfAccount, amount );
                    bank.add( account );
                    System.out.println( "Account information: " + account + "\n" );                
                    break;

                case 2: // Deposit into the currently active account
                    try {
                        amount = getAmount( keyboard );
                        account.deposit(amount);
                        System.out.println("Account information: " + account + "\n");
                    } catch (NullPointerException npe) {
                        System.out.println("ERROR: no active account! Search it before selecting this option or create a new one");
                    }
                    break;

                case 3: // Withdraw from the currently active account
                    amount = getAmount( keyboard );
                    try {
                        account.withdraw(amount);
                        System.out.println("Account information: " + account + "\n");
                    } catch (NullPointerException npe) {
                        System.out.println("ERROR: no active account! Search it before selecting this option or create a new one");
                    } catch (NoMoneyException nme) {
                        System.out.print(nme.getMessage());
                    }
                    break;

                case 4: // Search an account
                    numOfAccount = getNumOfAccount( keyboard );
                    temporaryAccount = bank.getAccount( numOfAccount );
                    if ( temporaryAccount != null ) {
                        account = temporaryAccount;
                        System.out.println( "Account information: " + account + "\n" );                
                    } else  {
                        System.out.println("\n***ERROR***: Account " + numOfAccount + " not found!\n" );                
                    }
                    break;

                case 5: // Show the currently active account
                    try {
                        System.out.println("Account information: " + account + "\n");
                    } catch (NullPointerException npe) {
                        System.out.println("ERROR: no active account! Search it before selecting this option or create a new one");
                    }
                    break;

                case 6: // Show all the accounts
                    System.out.print("\n\nALL THE ACCOUNTS: \n" + bank + "\n\n" );
                    break;

                case 7: //load accounts from file
                    System.out.print("Input the file name: ");
                    Scanner file = null;
                    try {
                        file = new Scanner(new File(keyboard.nextLine())).useLocale(Locale.US);
                        bank.loadFromTextFile(file);
                    } catch (FileNotFoundException fnfe ) {
                        System.out.println("ERROR: The file could not be found.");
                    } finally {
                        if (file != null) file.close();
                    }
                    break;

                case 8: //save accounts into text file
                    System.out.print("Input the file name: ");
                    PrintWriter pw = null;
                    try {
                        File f = new File(keyboard.nextLine());
                        if ( !f.exists() ) {
                            pw = new PrintWriter( f );
                            bank.saveIntoTextFile(pw);
                        } else {
                            throw new FileAlreadyExistsException("The file already exists.");
                        }
                    } catch (FileNotFoundException fnfe ) {
                        System.out.println("ERROR: file not found. " + fnfe.getMessage());
                    } catch (FileAlreadyExistsException faee) {
                        System.out.println(faee.getMessage());
                    } finally {
                        if (pw != null) pw.close();
                    }
                    break;

                case 9: //load accounts from binary file
                    System.out.print("Input the file name: ");
                    ObjectInputStream ois = null;
                    try {
                        ois = new ObjectInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(
                                                new File(keyboard.nextLine())
                                        )
                                )
                        );
                        bank.loadFromBinaryFile(ois);
                    } catch (EOFException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        System.out.println("ERROR: file doesn't exist. "+e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("ERROR: Account couldn't be read. " + e.getMessage());
                    } finally {
                        if (ois != null)
                            try {
                                ois.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    break;

                case 10: //save accounts to binary file
                    System.out.print("Input the file name: ");
                    ObjectOutputStream oos = null;
                    try{
                        File f = new File(keyboard.nextLine());
                        if( !f.exists() ) {
                            oos = new ObjectOutputStream(
                                    new BufferedOutputStream(
                                            new FileOutputStream(f)
                                    )
                            );
                            bank.saveIntoBinaryFile(oos);
                        } else {
                            throw new FileAlreadyExistsException("The file already exists.");
                        }
                    } catch (FileNotFoundException fnfe){
                        System.out.println("ERROR: file not found. " + fnfe.getMessage());
                    } catch (FileAlreadyExistsException faee) {
                        System.out.println(faee.getMessage());
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    } finally {
                        try {
                            if (oos != null) oos.close();
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }
                    }
                    break;

                case 11: //load bank from binary file (add accounts)
                    System.out.print("Input the file name: ");
                    ois = null;
                    try {
                        ois = new ObjectInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(
                                                new File(keyboard.nextLine())
                                        )
                                )
                        );
                        bank.loadBinary(ois);
                    } catch (EOFException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        System.out.println("ERROR: file doesn't exist. "+e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("ERROR: Account couldn't be read. " + e.getMessage());
                    } finally {
                        if (ois != null)
                            try {
                                ois.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                    break;

                case 12: //save bank to binary file
                    System.out.print("Input the file name: ");
                    oos = null;
                    try{
                        File f = new File(keyboard.nextLine());
                        if( !f.exists() ) {
                            oos = new ObjectOutputStream(
                                    new BufferedOutputStream(
                                            new FileOutputStream(f)
                                    )
                            );
                            bank.saveBinary(oos);
                        } else {
                            throw new FileAlreadyExistsException("The file already exists.");
                        }
                    } catch (FileNotFoundException fnfe){
                        System.out.println("ERROR: file not found. " + fnfe.getMessage());
                    } catch (FileAlreadyExistsException faee) {
                        System.out.println(faee.getMessage());
                    } catch (IOException ioe) {
                        System.out.println(ioe.getMessage());
                    } finally {
                        try {
                            if (oos != null) oos.close();
                        } catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                        }
                    }
                    break;

                case 0: // Exit
                    System.out.println("\n\nThe End!");
            }
        } while( op != 0 );
    }

    /**
     * Shows a menu with options on screen and allows to the user selecting one.
     * @param  keyboard Scanner object for reading from.
     * @return integer value corresponding to the selected option.
     */
    private static int menu( Scanner keyboard )
    {
        System.out.println( "------------- MENU --------------");
        System.out.println( " 0) Exit" );
        System.out.println( " 1) Create a new account" );
        System.out.println( " 2) Deposit into the currently active account" );
        System.out.println( " 3) Withdraw from the currently active account" );
        System.out.println( " 4) Search an account" );
        System.out.println( " 5) Show the currently active account" );
        System.out.println( " 6) Show all the accounts");
        System.out.println( " 7) Load accounts from file");
        System.out.println( " 8) Save accounts to file");
        System.out.println( " 9) Load accounts from binary file");
        System.out.println( "10) Save accounts to binary file");
        System.out.println( "11) Load bank accounts from binary file");
        System.out.println( "12) Save bank accounts to binary file");
        System.out.println( "---------------------------------");        
        return CorrectReading.nextInt( keyboard, "    Select an option (0 - 12): ", 0, 12 );
    }
 
    /**
     * Reads a real value >= 0.
     * @param  keyboard Scanner object for reading from.
     * @return double, real value >=0.
     */
    private static double getAmount( Scanner  keyboard )
    {
        return CorrectReading.nextRealPositive( keyboard, "\nAmount: " );
    }
  
    /**
     * Reads a valid id of account (a five digit integer).
     * @param keyboard Scanner object for reading from.
     * @return int, five digit integer representing the id of an account.
     */
    private static int getNumOfAccount( Scanner  keyboard )
    {
        return CorrectReading.nextInt( keyboard ,"\nId of account (5 digits): ", 10000, 99999 );
    }
}
