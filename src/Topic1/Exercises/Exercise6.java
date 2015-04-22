package Topic1.Exercises;

public class Exercise6 {
    public static int multiplication(int a, int b){
        if(b == 0) return 0;
        else return multiplication(a, b - 1) + a;
    }
}
