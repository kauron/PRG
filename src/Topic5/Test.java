package Topic5;

import java.util.Random;

public class Test {
    private static LinkedList lil, sil;
    private static boolean errors;

    public static void main(String[] args) throws Exception {
        while (!errors) {
            init((int) 1e3, (int) 1e6, 1000);
            show(false, false);
            lil.mergeSort();
//        lil.insertionSort();
            show(false, true);
            System.out.println(!errors);
        }
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
