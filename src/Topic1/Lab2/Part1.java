package Topic1.Lab2;

import Topic1.Exercises.Exercise19;

public class Part1 {
    public static boolean isPrefix(String a, String b){return Exercise19.isPrefix(a, b, 0);}
    public static boolean contains(String a, String b){return Exercise19.contains(a, b, 0);}

    public static boolean isPalindrome(String a){
        return isPalindrome(normalize(a.toLowerCase(), 0), 0, a.length() - 1);
    }
    private static boolean isPalindrome(String a, int left, int right){
        if(left >= right) return true;
        else if(!Character.isLetter(a.charAt(left)))
            return isPalindrome(a, left + 1, right);
        else if(!Character.isLetter(a.charAt(right)))
            return isPalindrome(a, left, right - 1);
        else if(a.charAt(left) != a.charAt(right)) return false;
        else return isPalindrome(a, left + 1, right - 1);
    }

    private static String normalize(String s, int i){
        if(i < s.length()){
            char c;
            switch(s.charAt(i)){
                case 'á': c = 'a'; break;
                case 'é': c = 'e'; break;
                case 'í': c = 'i'; break;
                case 'ó': c = 'o'; break;
                case 'ú': c = 'u'; break;
                default: c = s.charAt(i);
            }
            return c + normalize(s, i + 1);
        } else return "";
    }
}