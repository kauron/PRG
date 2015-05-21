package Topic5;

import java.util.Random;

public class Test {
    private static LinkedList lil, sil;
    private static boolean errors;

    public static void main(String[] args)
            throws Exception {
//        massiveTestInsertionSort();
        testInsertionSort(true);
//        testSortedInsertion(true);
    }

    public static void massiveTestInsertionSort() {
        errors = false;
        long probe = System.currentTimeMillis();
        for (int i = 0; i < 50; i++)
            testInsertionSort(false);
        System.out.printf("Test finished in %dms %s errors\n%d nodes sorted in %d lists\n",
                System.currentTimeMillis() - probe, errors ? "with" : "without", 50 * 200, 50);
    }

    public static void testInsertionSort(boolean verbose) {
        testSortedInsertion(verbose);

        lil.insertionSort();

        lil.begin();
        sil.begin();
        boolean match = true;
        while (sil.isValid()) {
            boolean accept = sil.get() == lil.get();
            match = match && accept;
            if (verbose) System.out.printf(" %5d  %5d %5s \n", lil.get(), sil.get(), accept);
            lil.next();
            sil.next();
        }
        if (verbose) System.out.println("\n" + match);
        errors = errors || !match;
    }

    public static void testSortedInsertion(boolean verbose) {
        Random r = new Random();

        lil = new LinkedList();
        sil = new LinkedList();

        int n = 8;
        for (int i = 0; i < n; i++) {
            int value = r.nextInt(100);
            lil.addEnd(value);
            sil.insertInOrder(value);
        }

        lil.begin();
        sil.begin();
        while (sil.isValid()) {
            if (verbose) System.out.printf(" %5d  %5d \n", lil.get(), sil.get());
            lil.next();
            sil.next();
        }
        if (verbose) System.out.println("\n");
    }
}
