package Topic4.Lab4;

/**
 * One exception of this class will be thrown when there is
 * no enough money for performing one transaction.
 *
 * @author PRG
 * @version Academic year 2014/15
 */

public class NoMoneyException extends Exception
{
    /**
	 * Constructor for creating a new exception of this class with a message.
     * @param message String with the message giving a short explanation of the error.
     */
    public NoMoneyException( String message )
    {
        super( message );
    }
}
