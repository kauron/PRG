package Topic5;

import java.util.Random;

public class Test {
    private static LinkedList lil, sil;
    private static boolean errors;

    public static void main(String[] args) throws Exception {
        initializeLists(10, 20, 1000);
        add(3000);
        add(2000);
//        massiveTestInsertionSort();
        testInsertionSort(true);
//        testSortedInsertion(true);
    }

    public static void add(int value) {
        lil.addEnd(value);
        sil.insertInOrder(value);
    }

    public static void massiveTestInsertionSort() {
        errors = false;
//        long probe = System.currentTimeMillis();
        while (!errors)
            testInsertionSort(true);
//        System.out.printf("Test finished in %dms %s errors\n%d nodes sorted in %d lists\n",
//                System.currentTimeMillis() - probe, errors ? "with" : "without", 50 * 200, 50);
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
        lil.begin();
        sil.begin();
        while (sil.isValid()) {
            if (verbose) System.out.printf(" %5d  %5d \n", lil.get(), sil.get());
            lil.next();
            sil.next();
        }
        if (verbose) System.out.println("\n");
    }

    public static void initializeLists(int min, int max, int maxValue) {
        initializeLists(new Random().nextInt(max - min) + min, maxValue);
    }

    public static void initializeLists(int size, int maxValue) {
        Random r = new Random();

        lil = new LinkedList();
        sil = new LinkedList();

        int n = size;
        for (int i = 0; i < n; i++) {
            int value = r.nextInt(maxValue);
            lil.addEnd(value);
            sil.insertInOrder(value);
        }
    }
}
