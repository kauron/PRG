package Topic1.Exercises;

public class Exercise3 {
    public static void printNumbers(int n){
        if(n > 0){
            System.out.print(n);
            printNumbers(n - 1);
        } //general case, otherwise do nothing
    }
}
