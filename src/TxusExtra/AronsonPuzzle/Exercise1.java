package TxusExtra.AronsonPuzzle;

import java.util.InputMismatchException;

/**
 * AronsonPuzzle.Exercise1 - First Aronson puzzle
 * Recursive implementation of Fibonacci algorithm, sum of figures of an
 * integer and Euclides greatest common divisor of two integers.
 * <p/>
 * Created by jevepa on 2/4/15.
 * PRG Workgroup "Eratostenes" of ARA group 1E1 of UPV ETSINF GII 2014/2015.
 * <p/>
 * TODO: raise exception on error on fib() instead of returning -1
 */

public class Exercise1 {

    /**
     * Recursive method for computing the <em>n</em>-th element of the
     * Fibonacci numbers sequence.
     *
     * @param n An integer, positive natural number.
     * @return The Fibonacci number sequence element of index <em>n</em>.
     */
    public static int fib(int n)
            throws InputMismatchException {
        if (n < 0) throw new InputMismatchException("Undefined.");
        if (n == 0) return 0;                   // trivial: fib(0)=0
        if (n <= 2) return 1;                   // trivial: fib(1)=fib(2)=1
        return fib(n - 1) + fib(n - 2);         // general case
    }

    /**
     * Recursive method for computing the sum of all the figures of an integer.
     *
     * @param n An integer.
     * @return The sum of the figures of the integer <em>n</em>.
     */
    public static int sumf(int n) {
        if (n < 0) n = -n;                      // fix for negative input
        if (n < 10) return n;                   // trivial case: only 1 figure
        return n % 10 + sumf(n / 10);           // general case
    }

    /**
     * Recursive method for computing the greatest common divisor of two
     * numbers (<em>a</em> and <em>b</em>) following the Euclidean algorithm.
     *
     * @param a An integer, containing one of the numbers to compute the gcd of.
     * @param b A integer, containing the other number to compute the gcd of.
     * @return The greatest common divisor of <em>a</em> and <em>b</em>.
     */
    public static int gcd(int a, int b) {
        // trivial case; both are equal
        if (a == b) return a;
        // finish condition: one of them is zero
        // thanks to "Von Neumann" workgroup for the a+b tip - :D
        if (a == 0 || b == 0) return a + b;
        // make positive: avoid stack overflow
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        // swap vars if b>a
        if (b > a) {
            a += b;
            b = a - b;
            a -= b;
        }

        return gcd(b, a % b);
    }
}
