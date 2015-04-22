package Topic1.Exercises;

public class Exercise8 {
    /**
     * Performs the power of b^exp
     * @param b base of the power, must be != 0
     * @param exp exponent, must be >= 0
     * @return the power b^exp
     */
    public static int power(int b, int exp){
        if (exp == 0) return 1;
        else if (exp == 1) return b;
        else if (exp % 2 == 0) return power(b, exp / 2) * power(b, exp / 2);
        else return power(b, exp / 2) * power(b, exp / 2) * b;

    }
}
