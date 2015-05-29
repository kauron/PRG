package Topic5;

import java.util.Random;

/**
 * Testing class to check if there are errors with the insertion or merge sort
 * implemented in the LinkedList class
 * This class needs LinkedList and NodeInt to work correctly
 */
public class Test {
    private static LinkedList lil, sil;
    private static boolean errors;

	/**
	 * Testing main that initializes with random numbers the lists and checks for errors
	 */
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

	/**
	 * Iterates through both lists, analysing or printing them
	 * If both parameters are false, the method will do nothing
	 * If both parameters are true, the method will display list and error information
	 * and check for errors
	 * @param print If true, the method will print the list
	 * @param check If true, the method will check for errors in sorting
	 */
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

	/**
	 * Insert an array of values at the end of both lists
	 * @param values Array of integers to be inserted
	 */
    public static void addEnd(int[] values) {
        for (int i : values) addEnd(i);
    }

	/**
	 * Insert a value at the end of both lists
	 * @param value Number to be inserted
	 */
    public static void addEnd(int value) {
        lil.addEnd(value);
        sil.insertInOrder(value);
    }

	/**
	 * Initializes both lists from an array of integer values
	 * @param values Array of integers containing the values to be inserted
	 */
    public static void init(int[] values) {
        init(0, 0);
        addEnd(values);
    }

	/**
	 * Initializes both lists with a random amount of random numbers
	 * @param min Minimum amount of numbers
	 * @param max Maximum amount of numbers - 1 (numbers in range [min, max[)
	 * @param maxValue Maximum value for the numbers, in range [0, maxValue[
	 */
    public static void init(int min, int max, int maxValue) {
        init(new Random().nextInt(max - min) + min, maxValue);
    }

    /**
	 * Initializes both lists with random numbers
	 * @param size Number of elements to be generated and inserted
	 * @param maxValue Maximum value for the numbers, in range [0, maxValue[
	 */
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
