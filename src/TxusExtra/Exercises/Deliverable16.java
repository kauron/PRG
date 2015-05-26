package TxusExtra.Exercises;

/**
 * Exercises.Deliverable16 - Deliverable 1.6
 * <p/>
 * Created by jevepa, jaiferhu and fragusa on 10/5/15.
 * PRG Workgroup "Eratostenes" of ARA group 1E1 of UPV ETSINF GII 2014/2015.
 * <p/>
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Deliverable16 {
    public static void main(String args[]) {
        int A[] = loadFromFile("fichero1.txt");
        int B[] = loadFromFile("fichero2.txt");
        sort(A);
        sort(B);
        int C[] = naturalMerge(A, B);
        saveToFile("fichero3.txt", C);
    }

    static int[] loadFromFile(String fileName) {
        int V[] = null;
        try {
            Scanner sf = new Scanner(new File(fileName));
            int n = sf.nextInt();
            V = new int[n];
            int i = 0;
            while (sf.hasNext()) {
                V[i++] = sf.nextInt();
            }
            sf.close();
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
            System.exit(-1);
        }

        return V;
    }

    static void saveToFile(String fileName, int V[]) {
        try {
            PrintWriter pw = new PrintWriter(new File(fileName));
            pw.println(V.length);
            for (int i = 0; i < V.length; i++) pw.print(V[i] + " ");
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    static void sort(int A[]) {
        for (int i = 1; i < A.length; i++) {
            int x = A[i];               // element to sort
            int j = i;                  // upper bound of sorted slice
            while (j > 0 && x < A[j - 1]) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = x;                   // store sorted value
        }
    }

    static int[] naturalMerge(int A[], int B[]) {
        int[] O = new int[A.length + B.length];

        // merge the arrays
        int ai = 0, bi = 0, oi = 0;      // indexes
        while (ai < A.length && bi < B.length) {
            if (A[ai] > B[bi]) {
                O[oi++] = B[bi++];
            } else {
                O[oi++] = A[ai++];
            }
        }

        // add the other array, no need to compare as the other should be empty
        while (ai < A.length) O[oi++] = A[ai++];
        while (bi < B.length) O[oi++] = B[bi++];

        return O;
    }

    static int binarySearch(int[] A, int x) {
        return BookExercises.binarySearch(A, x, 0, A.length);
    }
}
