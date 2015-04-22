package Topic1.Exercises;

public class Exercise22 {
    public static boolean isPalindrome(String s){
        return isPalindrome(s, 0, s.length() - 1);
    }
    private static boolean isPalindrome(String s, int b, int e){
        if(b >= e) return true;
        else if(s.charAt(b) != s.charAt(e)) return false;
        else return isPalindrome(s, b + 1, e - 1);
    }
}
