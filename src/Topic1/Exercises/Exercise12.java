package Topic1.Exercises;

public class Exercise12 {
    public static String decToBin(int n){
        if(n > 0) return decToBin(n / 2) + "" + n % 2;
        else return "";
    }
}