package Topic1.Exercises;

public class Exercise10 {
    public static int numDigits(int n){
        if(n < 10) return 1;
        else return numDigits(n / 10) + 1;
    }
}
