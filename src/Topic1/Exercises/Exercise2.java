package Topic1.Exercises;

public class Exercise2 {
    private static void printNumbers(int n){
        if(n == 0) return; //trivial case
        //general case
        printNumbers(n - 1);
        System.out.print(n);
    }
}