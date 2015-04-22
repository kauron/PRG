package Topic1.Exercises;

public class Exercise11 {
    public static void reverseInt(int n){
        if(n > 0){
            System.out.print(n % 10);
            reverseInt(n / 10);
        }
    }

    public static void reverseIntPRO(int n){
        if (n < 10){
            System.out.print(n % 10);
            reverseIntPRO(n / 10);
        }else{
            System.out.print(n);
        }
    }
}