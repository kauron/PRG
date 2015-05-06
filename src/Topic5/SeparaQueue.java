package Topic5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SeparaQueue {

    /**
     * Takes a list of integers from a file specified in the arguments and processes them,
     * separating them into two columns by means of the QueueIntLinked class
     * @param args The word "-input" followed by the file to scan's name
     */
    public static void main(String[] args) {
        Scanner input = null;

        if (args.length < 2 || !args[0].equals("-input")){
            System.out.println("Wrong arguments\nUsage: java SeparaQueue -input fileName");
            System.exit(99);
        } else {
            try{
                input = new Scanner ( new File( args[1] ) );
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.exit(100);
            }
        }

        QueueIntLinked positives = new QueueIntLinked();
        QueueIntLinked negatives = new QueueIntLinked();

        while(input.hasNextInt()) {
            int i = input.nextInt();
            if (i < 0) negatives.enqueue(i);
            else       positives.enqueue(i);
        }

        try {
            while (!negatives.isEmpty() && !positives.isEmpty())
                System.out.printf("%5d%5d\n", negatives.dequeue(), positives.dequeue());
            while (!negatives.isEmpty())
                System.out.printf("%5d\n", negatives.dequeue());
            while (!positives.isEmpty())
                System.out.printf("%5s%5d\n", "", positives.dequeue());
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(101);
        }
    }
}
