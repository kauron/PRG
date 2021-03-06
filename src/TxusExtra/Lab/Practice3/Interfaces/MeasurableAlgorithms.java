package TxusExtra.Lab.Practice3.Interfaces;

/**
 * Class MeasurableAlgorithms: utility class with methods of algorithms to be
 * measured. Modified to use an interface.
 *
 * @author jevepa
 * @version Year 2014-2015
 */

public class MeasurableAlgorithms {

    public interface SortingAlgorithm {
        String getName();
        void sort(int[] array);
    }


    public static class mergeSort implements SortingAlgorithm {
        public String getName() {
            return "merge";
        }

        public void sort(int[] a) {
            mergeSort(a, 0, a.length - 1);
        }

        private void mergeSort(int[] a, int i, int f) {
            // Only if the size of the slice of the array defined by
            // indexes 'i' and 'f' is greather than 1 the slice is
            // split again.
            if (i < f) {
                int h = (f + i) / 2;
                mergeSort(a, i, h); // Recursive call for the left part
                mergeSort(a, h + 1, f); // Recursive call for the right part
                naturalMerge(a, i, h, f); // Both parts are merged
            }
        }

        /**
         * Natural merge for mergesort
         *
         * @param a: array of integer
         * @param i: initial position of <code>a</code> to be considered
         * @param f: final position of <code>a</code> to be considered
         * @param h: middle position of <code>a</code> to be considered
         */
        private void naturalMerge(int[] a, int i, int h, int f) {
            // A temporary array is created for storing the merged sorted slices
            int[] temp = new int[f - i + 1];
            int k = 0, i_temp = i, j_temp = h + 1, k_temp;

            // While values are available in both slices
            while (i_temp <= h && j_temp <= f) {
                // The smallest one of the pending values is copied to the temporary array
                if (a[i_temp] < a[j_temp]) {
                    temp[k] = a[i_temp];
                    i_temp++;
                } else {
                    temp[k] = a[j_temp];
                    j_temp++;
                }
                k++;
            }
            while (i_temp <= h) {
                temp[k] = a[i_temp];
                i_temp++;
                k++;
            }
            while (j_temp <= f) {
                temp[k] = a[j_temp];
                j_temp++;
                k++;
            }

            // This additional code is needed to copy the values in the temporary
            // array to the 'a'
            k_temp = 0;
            for (i_temp = i; i_temp <= f; i_temp++) {
                a[i_temp] = temp[k_temp];
                k_temp++;
            }
        }
    }

    public static class insertionSort implements SortingAlgorithm {
        public String getName() {
            return "insertion";
        }

        /**
         * Insertion sorting method
         *
         * @param a: array of integer
         */

        public void sort(int[] a) {
            int i, j, temp;

            for (i = 1; i < a.length; i++) {
                j = i - 1;
                temp = a[i];
                while (j >= 0 && a[j] > temp) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }


    public static class selectionSort implements SortingAlgorithm {
        public String getName() {
            return "selection";
        }

        /**
         * Selection sorting method
         *
         * @param a: array of integer
         */

        public void sort(int[] a) {
            int i, j, posMin, temp;

            for (i = 0; i < a.length - 1; i++) {
                posMin = i;
                for (j = i + 1; j < a.length; j++)
                    if (a[j] < a[posMin]) posMin = j;

                if (posMin != i) {
                    temp = a[posMin];
                    a[posMin] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
