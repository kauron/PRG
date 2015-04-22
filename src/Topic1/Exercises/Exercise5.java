package Topic1.Exercises;

public class Exercise5 {
    public static int division(int a, int b){
        if(a < b){return 0;}
        else{return division(a-b, b) + 1;}
    }
}
