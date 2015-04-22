package Topic3.Exercises;

import Topic3.Exercises.Error.InvalidValueException;
import java.util.*;

public class ReadNumbersOriginal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int n = 0;
        do {
            System.out.print("Enter an integer number from 1 up to 100, both included: ");
            try {
                n = input.nextInt();
                if (n < 1 || n > 100) {
                    n = 0;
                    throw new InvalidValueException("Invalid number, the value must be in the range [1, 100].");
                }
            } catch (InvalidValueException ive) {
                System.err.println(ive.getMessage());
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input, please input an integer.");
            } finally {
                input.nextLine();
            }
        } while (n == 0);

        double x = -1;
        do {
            System.out.print("Enter a real number in the range [0, 1]: ");
            try {
                x = input.nextDouble();
                if (x < 0.0 || x > 1.0) {
                    x = -1;
                    throw new InvalidValueException("Invalid number, the value must be in the range [0, 1].");
                }
            } catch (InvalidValueException ive) {
                System.err.println(ive.getMessage());
            } catch (InputMismatchException ime) {
                System.err.print("Invalid input, please input a real number");
            } finally {
                input.nextLine();
            }
        } while (x == -1);

        System.out.printf("\n\n n = %d    x = %f\n\n\n", n, x);
    }
}
