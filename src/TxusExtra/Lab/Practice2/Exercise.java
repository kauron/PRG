package TxusExtra.Lab.Practice2;

/**
 * Created by txus on 2/17/15.
 */

public class Exercise {

    public static void main(String[] args) {
        String p = "Eva usaba rimel y le miraba suave.";
        String sp1 = "Eva usa";
        String sp2 = "usaba rimel y le";
        System.out.println(isPalindrome(p));
        System.out.println(isPrefix(p, sp1));
        System.out.println(contains(p, sp2));
    }

    public static boolean isPrefix(String s, String t) {
        return BookExercises.isPrefix(s, t);
    }

    public static boolean contains(String s, String t) {
        return BookExercises.contains(s, t);
    }


    public static boolean isPalindrome(String s) {
        return isPalindrome(s.toLowerCase(), 0, s.length() - 1);
    }

    public static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) return true;
        if (!Character.isLetter(s.charAt(l))) return isPalindrome(s, l + 1, r);
        if (!Character.isLetter(s.charAt(r))) return isPalindrome(s, l, r - 1);
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }

}
