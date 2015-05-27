package TxusExtra.Lab.Practice5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by baudlord on 5/19/15.
 */
public class concor {
    public static void main(String[] args) {
        boolean sorted = false;
        if (args[0] == "-o") {
            sorted = true;
        }

        Scanner load = null;
        try {
            load = new Scanner(new FileInputStream(new File(args[sorted ? 1 : 0])));
            System.out.print(new Concordance(load, sorted));
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        }
    }
}
