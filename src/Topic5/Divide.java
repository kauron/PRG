package Topic5;

import java.io.File;
import java.util.Scanner;

public class Divide {
    /**
     * Scans a file that contains integer numbers and separates them into two columns,
     * respecting the order and using StackIntLinked objects.
     * @param args String[] Parameters of the call (-input filename)
     * @throws StackUnderflowException It is never thrown because the if statements check if the Stack is empty or not.
     */
    public static void main (String[] args) throws StackUnderflowException {
        //Scanner to get the numbers from the file inputed as a parameter
        Scanner input = null;
        if (args.length < 2 || !args[0].equals("-input")) {
            System.out.println("Usage: java Divide -input fileName");
            System.exit(1);
        }
        try {
            input = new Scanner (new File (args[1]));
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
