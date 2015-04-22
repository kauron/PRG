package Topic3.Lab4;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class CorrectReading: class of utilities for performing correct read operations from standard input for built-in data types.
 * 
 * @author PRG 
 * @version Academic year 2014/15
 */

public class CorrectReading
{
    /**
     * Reads from a Scanner object and returns a double value checking that it is positive.
     * @param keyboard Scanner object for reading from.
     * @param message String for asking the user for the value.
     * @return double, a non-negative double value.
     */    
    public static double nextRealPositive( Scanner keyboard, String message )
    {
        double value = 0.0;
        do {
            if (message != null)
                System.out.print( message );
            try {
                value = keyboard.nextDouble();
            } catch (InputMismatchException ime) {
                System.err.println("Please, enter a correct real number! Try it again");
            } finally {
                keyboard.nextLine();
            }
        } while( value < 0.0 );
        return value;
    }

    /**
     * Reads from a Scanner object and returns an integer value. 
     * @param keyboard Scanner object for reading from.
     * @param message String for asking to the user for the value.
     * @return int, the integer value user entered.
     */
    public static int nextInt( Scanner keyboard, String message )
    {
        int value = 0;
        boolean someError = true; 
        do {
            try {
                if (message != null)
                    System.out.print( message );
                value = keyboard.nextInt();
                someError = false;
            }
            catch( InputMismatchException e ) {
                System.out.println( "Please, enter a correct integer value! Try it again ... " );
            }
            finally {
                keyboard.nextLine();
            }

        } while( someError );

        return value;
    }

    /**
     * Reads from a Scanner object and resturns an integer value in the range <code>[ lowerBound .. upperBound ]</code>
     * where <code>Integer.MIN_VALUE <= lowerBound</code> and <code>upperBound <= Integer.MAX_VALUE</code>.
     * @param keyboard Scanner object for reading from.
     * @param message String for asking to the user for the value.
     * @param lowerBound int lower bound of the value to be read and accepted.
     * @param upperBound int upper bound of the value to be read and accepted.
     * @return int, the integer number entered by the user.
     */    
    public static int nextInt( Scanner keyboard, String message, int lowerBound, int upperBound )
    {
        int value = lowerBound - 1;
        boolean error;
        do {
            try {
                value = nextInt(keyboard, message);
                if (value < lowerBound || value > upperBound)
                    throw new IllegalArgumentException(
                            String.format("Input a number in the range [%d, %d]", lowerBound, upperBound)
                    );
                error = false;
            } catch (IllegalArgumentException iae) {
                error = true;
                if (message != null)
                    System.err.println(iae.getMessage());
            }
        } while ( error );
        return value;
    }

}
