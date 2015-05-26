package TxusExtra.Lab.Practice3.Interfaces;

/**
 * Class SortingMeasure: program class to implement the empirical
 * time measure of sorting algorithms.
 * Modified to use an interface.
 *
 * @author PRG ETSInf
 * @author jevepa@inf.upv.es
 * @version Year 2014-2015
 * @see MeasurableAlgorithms
 */

public class SortingMeasure {
    // Constants that define the measure parameters
    static final int MAXSIZE = 200000,
            INCRSIZE = 1000,
            INITSIZE = 0,
            REPETITIONS = 10;

    static final double NMS = 1.0e3;

    // Define the static final variables that are needed for the experiment
    private final static java.util.Random r = new java.util.Random();

    /* Apart from the measuring methods, you can implement the auxiliary *
     * static methods that you consider necessary for the empirical      *
     * measure (e.g., methods to generate arrays of data)                */

    private static void fillSortedArray(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = i + 1;
    }

    private static void fillSortedArrayInReverseOrder(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = a.length - i;
    }

    private static void fillRandomArray(int[] a) {
        for (int i = 0; i < a.length; i++) a[i] = r.nextInt(a.length);
    }

    public static void measure(MeasurableAlgorithms.SortingAlgorithm algorithm) {
        System.out.println("Measuring " + algorithm.getName() + " sort...");

        // initialize variables
        int[] a;        // Array for the problem
        int s, r;        // Sizes counter, repetitions counter, auxiliary random number
        long tb1 = 0, tb2 = 0, tbt = 0, tw1 = 0, tw2 = 0, twt = 0, ta1 = 0, ta2 = 0, tat = 0;     // Times

        // Print header for the results
        System.out.printf("# Size             Best          Worst        Average   (ms) \n");
        System.out.printf("#------------------------------------------------------------\n");

        for (s = INITSIZE; s <= MAXSIZE; s += INCRSIZE) {

            // Create the array and fill it
            a = new int[s];

            // Best case: sorted
            fillSortedArray(a);
            algorithm.sort(a); // pop a few
            tb1 = System.nanoTime();        // Initial time
            for (r = 0; r < REPETITIONS; r++)
                algorithm.sort(a);
            tb2 = System.nanoTime();        // Final time
            tbt = (tb2 - tb1) / REPETITIONS;    // Average time for best case;
            if (tbt > 400000 * NMS) break;

            // Worst case: sorted, inverse order
            fillSortedArrayInReverseOrder(a);
            algorithm.sort(a);      // pop a few
            for (r = 0; r < REPETITIONS; r++) {
                fillSortedArrayInReverseOrder(a);
                tw1 = System.nanoTime();
                algorithm.sort(a);
                tw2 = System.nanoTime();
                twt += tw2 - tw1;
            }
            twt = twt / REPETITIONS;
            if (twt > 400000 * NMS) break;

            // Average case: sort a random alg
            fillRandomArray(a);
            algorithm.sort(a);      // pop a few

            for (r = 0; r < REPETITIONS; r++) {
                fillRandomArray(a);
                ta1 = System.nanoTime();      // Initial time
                algorithm.sort(a);
                ta2 = System.nanoTime();      // Final time
                tat += (ta2 - ta1);             // Update cumulative time
            }
            tat = tat / REPETITIONS;          // Average time for average case
            if (tat > 400000 * NMS) break;

            // Print results
            System.out.printf("%8d   %12.2f   %12.2f   %12.2f\n", s, tbt / NMS, twt / NMS, tat / NMS);
        }
    }

    public static void usage() {
        System.out.println("Usage: java SortingMeasure algorithm_number");
        System.out.println("   Where algorithm_number is:");
        System.out.println("   1 -> Insertion sort");
        System.out.println("   2 -> Selection sort");
        System.out.println("   3 -> MergeSort");
    }

    public static void main(String[] args) {
        int a;

        if (args.length != 1) {
            usage();
            return;
        }

        try {
            a = Integer.parseInt(args[0]);
        } catch (Exception e) {
            usage();
            return;
        }

        switch (a) {
            case 1:
                measure(new MeasurableAlgorithms.insertionSort());
                break;
            case 2:
                measure(new MeasurableAlgorithms.selectionSort());
                break;
            case 3:
                measure(new MeasurableAlgorithms.mergeSort());
                break;
            default:
                usage();
        }
    }
}
