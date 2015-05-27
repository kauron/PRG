package TxusExtra.Exercises;

/**
 * Created by txus on 2/7/15.
 */
public class BookExercises {

    /**
     * Exercise 2
     * <p/>
     * Recursive method that shows on screen the natural numbers from
     * <em>LOWERLIMIT</em> up to <em>n</em>.
     *
     * @param n An integer, positive, containing the last number to print.
     */
    public static void printAscending(int n) {
        final int LIMIT = 0;
        n = Math.abs(n);

        if (n == LIMIT) {
            System.out.println(LIMIT);
        } else {
            printAscending(n - 1);
            System.out.println(n);
        }
    }

    /**
     * Exercise 3
     * <p/>
     * Recursive method that shows on screen the natural numbers from
     * <em>n</em> up to <em>LOWERLIMIT</em>.
     *
     * @param n An integer, positive, containing the first number to print.
     */
    public static void printDescending(int n) {
        final int LIMIT = 0;
        n = Math.abs(n);

        if (n == LIMIT) {
            System.out.println(LIMIT);
        } else {
            System.out.println(n);
            printDescending(n - 1);
        }
    }

    /**
     * Exercise 5
     * <p/>
     * Recursive method that divides two integer numbers and returns the integer
     * part of the quotient.
     *
     * @param a An integer, containing the dividend.
     * @param b An integer, containing the divisor.
     * @return An integer, containing the integer part of a divided by b.
     */
    public static int quotientInt(int a, int b) {
        return (a > b) ? 1 + quotientInt(a - b, b) : 0;
    }

    /**
     * Exercise 7
     * <p/>
     * Recursive method to implement Russian Peasant Multiplication.
     *
     * @param a An integer, one of the factors of the multiplication.
     * @param b Another integer, another one of the factors of the multiplication.
     * @return Product of a and b.
     */
    public static int rusMultiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (b > 0) {
            int r = rusMultiply(2 * a, b / 2);
            return (b % 2 == 0) ? r : r + a;
        }
        return 0;
    }

    /**
     * Recursive method to print on screen an integer reversed.
     *
     * @param n An integer, containing the integer to reverse.
     */
    public static void reverse(int n) {
        n = Math.abs(n);
        if (n < 10) {
            System.out.print(n);
        } else {
            System.out.print(n % 10);
            reverse(n / 10);
        }
    }

    /**
     * Faster implementation of reverse().
     *
     * @param n An integer, containing the integer to reverse.
     */
    public static void reverse2(int n) {
        System.out.print(n % 10);
        if (n >= 10) reverse2(n / 10);
    }

    /**
     * PascalTriangle
     */
    public static void PascalTriangle(int height) {
        // print the pascal triangle
    }

    public static int pascal(int c, int r) {
        if (c == 0 || c == r) {
            return 1;
        } else {
            return pascal(c - 1, r) + pascal(c - 1, r - 1);
        }
    }

    /**
     * Exercise 13 of recursion.pdf
     */
    public static boolean isPrefix(String s, String prefix) {
        if (prefix.length() > s.length()) return false;
        return isPrefix(s, prefix, 0);
    }

    private static boolean isPrefix(String s, String prefix, int i) {
        if (i >= prefix.length()) return true;
        if (s.charAt(i) != prefix.charAt(i)) return false;
        return isPrefix(s, prefix, i + 1);
    }


    public static boolean isSuffix(String s, String suffix) {
        if (suffix.length() > s.length()) return false;
        return isSuffix(s, suffix, 0);
    }

    private static boolean isSuffix(String s, String suffix, int i) {
        if (i > suffix.length()) return true;
        if (s.charAt(s.length() - 1 - i) != suffix.charAt(suffix.length() - 1 - i))
            return false;
        return isSuffix(s, suffix, i + 1);
    }

    public static boolean contains(String s, String t) {
        if (t.length() > s.length()) return false;
        if (isPrefix(s, t, 0)) return true;
        return contains(s.substring(1), t);
    }

    /**
     * Recursive binary search.
     */
    public static int binarySearch(int[] A, int x, int l, int r) {
        if (l > r) return -1;

        int k = (r + l) / 2;
        if (A[k] == x) return k;
        else if (A[k] < x) {
            return binarySearch(A, x, l, k - 1);
        } else {
            return binarySearch(A, x, k + 1, r);
        }
    }
}
