package Topic5;

import java.io.File;
import java.util.Scanner;

public class Divide {
    /**
     * Scans a file that contains integer numbers and separates them into two columns,
     * respecting the order and using StackIntLinked objects.
     * @param args Not used
     * @throws StackUnderflowException It is never thrown because the if statements check if the Stack is empty or not.
     */
    public static void main (String[] args) throws StackUnderflowException {
        //Scanner to get the numbers from the file
        Scanner input = null;

        try {
            input = new Scanner (new File ("datos.in"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        //Get all the inputs in a single Stack
        StackIntLinked ints = new StackIntLinked();
        while (input.hasNextInt())
            ints.push(input.nextInt());

        //Divide the ints in positive or negative
        StackIntLinked positives = new StackIntLinked();
        StackIntLinked negatives = new StackIntLinked();

        while (!ints.isEmpty()) {
            int i = ints.pop();
            if (i < 0) negatives.push(i);
            else       positives.push(i);
        }

        //Print the stacks
        while ( !positives.isEmpty() || !negatives.isEmpty() ) {
            if ( !positives.isEmpty() && !negatives.isEmpty() )
                System.out.printf("%5d%5d\n", negatives.pop(), positives.pop());
            else if ( !positives.isEmpty() )
                System.out.printf("%5s%5d\n", " ", positives.pop());
            else if ( !negatives.isEmpty() )
                System.out.printf("%5d\n", negatives.pop());
        }
    }
}
