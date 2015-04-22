package Topic1.Exercises;

public class Exercise9 {
    public static int sumDigits(int n){
        if(n < 10) return n;
        else return sumDigits(n / 10) + n % 10;
    }
}
