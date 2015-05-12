package Topic4.Lab4;

import java.io.Serializable;

/**
 * Class Account for representing an account in a bank.
 * @author PRG 
 * @version Academic year 2014/15
 */
public class Account implements Serializable
{
    private double balance;
    private int accountId;

    /**
     * Constructor for creating a new account given two parameters, the number of the account and the initial balance.
     *
     * @param accountId       int indicating the number of this account.
     *                        Must be a five digit integer.
     * @param initialBalance  double value with the initial balance.
     *                        Must be greater than or equal to zero. No negative balance is accepted.
     */
    public Account( int accountId, double initialBalance )
    {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    /**
     * For registering a deposit of money in this account.
     * @param amount double indicating the amount of money in the currency to be deposited.
     *               Must be >=0.
     */    
    public void deposit( double amount ) { balance += amount; }

    /**
     * For registering a withdrawal of money in this account.
     * @param amount double indicating the amount of money in the currency to be withdrawn.
     *               Must be >=0.
     */ 
    public void withdraw ( double amount ) throws NoMoneyException {
        if(amount <= balance)
            balance -= amount;
        else
            throw new NoMoneyException("Impossible to withdraw more money than the available");
    }

//    /**
//     * Getter method for obtaining the value of the balance.
//     * @return double, the current balance.
//     */
//    public double getBalance() { return balance; }

    /**
     * Getter method for obtaining the number of the account.
     * @return int, the number of the account.
     */
    public int getAccountId() { return accountId; }

    /**
     * Returns a String object representing this account in the following format:
     * <code>account id</code>  <code>balance</code>.
     *
     * For example, 12345 100.52 where 12345 is the number of the account and
     * 100.52 is the balance.
     *
     * @return String.
     */
    public String toString()
    {
        return accountId + " " + balance;
    }
}
