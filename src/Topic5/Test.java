package Topic5;

import java.util.Random;

public class Test {
    private static LinkedList lil, sil;
    private static boolean errors;

    public static void main(String[] args) throws Exception {
        int errorCount = 0;
        int totalElements = 0;
        int REPETITIONS = 1000;
        long begin = System.nanoTime();
        for (int i = 0; i < REPETITIONS; i++) {
            init(1000, Integer.MAX_VALUE);
            totalElements += lil.size();
            show(false, false);
            lil.mergeSort();
//        lil.insertionSort();
            show(false, true);
            if (errors) {
                System.out.printf("%3d-. Execution #%d\n\n", ++errorCount, i);
                show(true, true);
            }
        }
        long end = System.nanoTime();
        System.out.printf("\nTotal success ratio: %2.2f%%\n%d executions, %d errors\n" +
                        "%d total elements, %.2f average\nTime elapsed: %.2fs\nTime per list: %.6fus\n",
                100 - errorCount * 100.0 / REPETITIONS,
                REPETITIONS, errorCount,
                totalElements, totalElements / (double) REPETITIONS,
                (end - begin) / 1e9, (end - begin) / (1e3 * REPETITIONS));
    }

    public static void show(boolean print, boolean check) {
        lil.begin();
        sil.begin();
        boolean match = true;
        while (sil.isValid()) {
            boolean accept = false;
            if (check) {
                accept = sil.get() == lil.get();
                match = match && accept;
            }
            if (print) System.out.printf(" %5d  %5d ", lil.get(), sil.get());
            if (print && check) System.out.print(accept);
            if (print) System.out.println();

            lil.next();
            sil.next();
        }
        if (print && check) System.out.println("\n" + match);
        if (check) errors = errors || !match;
        if (print) System.out.println();
    }

    public static void addEnd(int[] values) {
        for (int i : values) addEnd(i);
    }

    public static void addEnd(int value) {
        lil.addEnd(value);
        sil.insertInOrder(value);
    }

    public static void init(int[] values) {
        init(0, 0);
        addEnd(values);
    }

    public static void init(int min, int max, int maxValue) {
        init(new Random().nextInt(max - min) + min, maxValue);
    }

    public static void init(int size, int maxValue) {
        Random r = new Random();

        errors = false;

        lil = new LinkedList();
        sil = new LinkedList();

        for (int i = 0; i < size; i++) {
            int value = r.nextInt(maxValue);
            lil.addEnd(value);
            sil.insertInOrder(value);
        }
    }
}
