package Topic1.Exercises;

public class Exercise20 {
    public static void showInverseChars(String s, int l){
        if((l != 1) && (l <= s.length())) {
            System.out.print(s.charAt(l - 1));
            showInverseChars(s, l - 1);
        }else System.out.println(s.charAt(0));
    }
}
