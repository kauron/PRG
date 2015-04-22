package Topic1.Exercises;

public class Exercise21 {
    public static void showInverse(String s){
        if(s.length() != 0){
            System.out.print(s.charAt(s.length() - 1));
            showInverse(s.substring(0, s.length() - 1));
        }
    }

    //You can always link that method to the one below by prompting only
    // showInverse(s, s.length - 1);

    private static void showInverse(String s, int i){
        if(i != 0){
            System.out.print(s.charAt(i));
            showInverse(s, i - 1);
        }else{
            System.out.println(s.charAt(0));
        }
    }
}
