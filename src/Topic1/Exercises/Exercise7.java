package Topic1.Exercises;

public class Exercise7 {
    public static int russianMult(int a, int b){
        if(b == 0) return 0;
        else if(b % 2 == 0) return russianMult(2*a, b/2);
        else return russianMult(a*2, b/2) + a;
    }
}
