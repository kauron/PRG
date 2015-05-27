package TxusExtra.Exercises;

/**
 * Exercises.Deliverable51 - Deliverable 5.1
 * <p/>
 * Created by jevepa, jaiferhu and fragusa on 10/5/15.
 * PRG Workgroup "Eratostenes" of ARA group 1E1 of UPV ETSINF GII 2014/2015.
 * <p/>
 */

import linear.StackIntLinked;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Deliverable51 {
    public static void main(String[] args) {
        Scanner in = null;

        try {
            in = new Scanner(new File(args[0])).useLocale(Locale.US);
        } catch (FileNotFoundException ex) {
            System.err.println("Error finding the file" + ex.getMessage());
            System.exit(0);
        }

        // load and split
        StackIntLinked pos = new StackIntLinked();
        StackIntLinked neg = new StackIntLinked();

        for (int i = 0; in.hasNextInt(); i++) {
            int aux = in.nextInt();
            if (aux >= 0) {
                pos.push(aux);
            } else {
                neg.push(aux);
            }
        }

        in.close();

        // reverse the stacks
        // in-place is not any faster or cheaper in memory (?)
        StackIntLinked pos2 = new StackIntLinked();
        StackIntLinked neg2 = new StackIntLinked();
        while (!pos.isEmpty()) {
            try {
                pos2.push(pos.pop());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while (!neg.isEmpty()) {
            try {
                neg2.push(neg.pop());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        pos = pos2;
        neg = neg2;

        // PrintStream out = System.out; //stdout
        PrintWriter out = null;

        try {
            out = new PrintWriter(new File(args[1]));
        } catch (FileNotFoundException ex) {
            System.err.println("Error finding the file" + ex.getMessage());
            System.exit(0);
        }

        while (!pos.isEmpty() || !neg.isEmpty()) {
            try {
                if (!pos.isEmpty()) {
                    out.printf("%-10d", pos.pop());
                } else {
                    out.printf("%-10s", ' ');
                }
                System.out.print('\t');
                if (!neg.isEmpty()) {
                    out.printf("%-10d", neg.pop());
                } else {
                    out.printf("%-10s", ' ');
                }
                out.print('\n');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        out.close();
    }
}