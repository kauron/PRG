package Topic5.Lab5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class concor {
    private static final String DELIMITERS = "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]+";

    public static void main (String[] args) {
        if (args.length == 2 && args[0].equals("-do")) {
            try {
                Concordance c = new Concordance(new Scanner(new File(args[1])), true, DELIMITERS);
                c.save("saved.dat");
                String toString = c.toString();
                c = Concordance.load("saved.dat");
                System.out.println(toString.equals(c.toString()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Concordance c;
                if (args.length != 0) {
                    if (args[0].equals("-o")) {
                        if (args.length > 1) {
                            c = new Concordance(new Scanner(new File(args[1])), true, DELIMITERS);
                        } else {
                            c = new Concordance(new Scanner(System.in), true, DELIMITERS);
                        }
                    } else {
                        c = new Concordance(new Scanner(new File(args[0])), false, DELIMITERS);
                    }
                } else {
                    c = new Concordance(new Scanner(System.in), false, DELIMITERS);
                }

                System.out.println(c);
            } catch (FileNotFoundException e) {
                System.out.println("There was an error");
                System.out.println("Usage: java concor [-o] [filename]");
                System.out.println("\t-o: the concordance will be sorted, if nothing is inputted the concordance will be unsorted");
                System.out.println("\tfilename: name of the file, if nothing is inputted then the program reads the user input until a Ctrl-D signal is inputted");
            }
        }
    }
}