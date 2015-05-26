package TxusExtra.AronsonPuzzle;

/**
 * Created by txus on 2/13/15.
 */
public class Exercise2 {
    public static int sumOfArray(int[] A) {
        return sumOfArray(A, 0);
    }

    private static int sumOfArray(int[] A, int i) {
        if (A.length == 1) return A[0];
        return A[i] + sumOfArray(A, i + 1);
    }

    public static int posMax(int[] A) {
        if (A.length == 1) return A[0];
        return posMax(A, 1, A[0]);
    }

    private static int posMax(int[] A, int i, int m) {
        if (i > A.length) return m;
        return (A[i] > m) ? posMax(A, i + 1, A[i]) : posMax(A, i + 1, m);
    }

    public static int posMin(int[] A) {
        if (A.length == 1) return A[0];
        return posMin(A, 1, A[0]);
    }

    private static int posMin(int[] A, int i, int m) {
        if (i > A.length) return m;
        return (A[i] < m) ? posMin(A, i + 1, A[i]) : posMin(A, i + 1, m);
    }

    public static boolean isSorted(int[] A) {
        return isSorted(A, 1, A[0]);
    }

    private static boolean isSorted(int[] A, int i, int m) {
        return m <= A[i] && isSorted(A, i + 1, A[i]);
    }

    public static int posFirstNonNull(int[] A) {
        return posFirstNonNull(A, 0);
    }

    private static int posFirstNonNull(int[] A, int i) {
        // is there a type-agnostic array class?
        if (A[i] != 0) return i;        // supposing null as 0
        return (i > 0) ? posFirstNonNull(A, i - 1) : -1;
    }

    public static int posLastNonNull(int[] A) {
        return posLastNonNull(A, A.length - 1);
    }

    private static int posLastNonNull(int[] A, int i) {
        // is there a type-agnostic array class?
        if (A[i] != 0) return i;        // supposing null as 0
        return (i > 0) ? posLastNonNull(A, i - 1) : -1;
    }

    public static int consecutiveZeroesEnd(int[] A) {
        return consecutiveZeroesEnd(A, A.length - 1, 0);
    }

    private static int consecutiveZeroesEnd(int[] A, int i, int c) {
        if (A[i] == 0) {
            c++;
            return consecutiveZeroesEnd(A, i - 1, c);
        }
        return c;
    }

    public static int consecutiveZeroesStart(int[] A) {
        return consecutiveZeroesEnd(A, 0, 0);
    }

    private static int consecutiveZeroesStart(int[] A, int i, int c) {
        if (A[i] == 0) {
            c++;
            return consecutiveZeroesEnd(A, i + 1, c);
        }
        return c;
    }

//    public static void rangeInvert(int[] A, int l, int r){
//        if (l >= r) return;
//        A[l] = A[r] +
//        A[l] = A[r];
//        A[r] = A[l];
//
//        l++; r--;
//
//        if (A.length)
//    }

}