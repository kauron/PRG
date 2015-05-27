package TxusExtra.Lab.Practice4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class CorrectReading: class of utilities for performing correct read operations from standard input for built-in data types.
 *
 * @author PRG
 * @version Academic year 2014/15
 */

public class CorrectReading {
    /**
     * Reads from a Scanner object and returns a double value checking that it is positive.
     *
     * @param keyboard Scanner object for reading from.
     * @param message  String for asking the user for the value.
     * @return double, a non-negative double value.
     */
    public static double nextRealPositive(Scanner keyboard, String message) {
        double value = 0.0;
        boolean error = true;
        do {
            try {
                System.out.print(message);
                value = keyboard.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please, enter a correct double value! Try it again ... ");
            } finally {
                keyboard.nextLine();
            }
        } while (value < 0.0);

        return value;
    }

    /**
     * Reads from a Scanner object and returns an integer value.
     *
     * @param kbd     Scanner object for reading from.
     * @param message String for asking to the user for the value.
     * @return int, the integer value user entered.
     */
    public static int nextInt(Scanner kbd, String message) {
        int value = 0;
        boolean error = true;
        do {
            try {
                System.out.print(message);
                value = kbd.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Please, enter a correct integer value! Try it again ... ");
            } finally {
                kbd.nextLine();
            }

        } while (error);

        return value;
    }

    /**
     * Reads from a Scanner object and returns an integer value in the range <code>[ lowerBound .. upperBound ]</code>
     * where <code>Integer.MIN_VALUE <= lowerBound</code> and <code>upperBound <= Integer.MAX_VALUE</code>.
     *
     * @param kbd        Scanner object for reading from.
     * @param message    String for asking to the user for the value.
     * @param lowerBound int lower bound of the value to be read and accepted.
     * @param upperBound int upper bound of the value to be read and accepted.
     * @return int, the integer number entered by the user.
     */
    public static int nextInt(Scanner kbd, String message, int lowerBound, int upperBound) {
        int value = 0;
        boolean error = true;

        do {
            try {
                value = nextInt(kbd, message);
                if (value < lowerBound || value > upperBound)
                    throw new IllegalArgumentException(String.format("Please, enter a value between %d and %d.\n", lowerBound, upperBound));
                error = false;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        } while (error);
        return value;
    }

}

