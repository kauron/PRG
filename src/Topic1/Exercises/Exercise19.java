package Topic1.Exercises;

/**Class to operate with strings without using contains or check for prefixes/suffixes
 *
 */
public class Exercise19 {

    private static final boolean OPTIMIZE = true;

    /** Checks if s2 is a prefix of s1
     *
     * @param s1 Word with a prefix
     * @param s2 Prefix
     * @return True if s2 matches the first s2.length() chars of s1
     */
    public static boolean isPrefix(String s1, String s2){
        if(!OPTIMIZE) {
            if (s2.length() > s1.length()) return false;
            else if (s2.length() == 0) return true;
            else if (s2.charAt(0) != s1.charAt(0)) return false;
                //this line can be omitted, substring(1) if length = 1, returns ""
                //else if(s2.length() < 2) return true;
            else return isPrefix(s1.substring(1), s2.substring(1));
        } else {
            return isPrefix(s1, s2, 0);
        }
    }

    /** Checks if s2 is a prefix of s1
     *
     * @param s1 Word with a prefix
     * @param s2 Prefix
     * @param i MUST be 0
     * @return True if s2 matches the first s2.length() chars of s1
     */
    public static boolean isPrefix(String s1, String s2, int i){
        if(s2.length() > s1.length()) return false;
        else if(i >= s2.length()) return true;
        else if(s2.charAt(i) != s1.charAt(i)) return false;
        else return isPrefix(s1, s2, i + 1);
    }

    /** Checks if s2 is suffic of s1
     *
     * @param s1 Word with a suffix
     * @param s2 Suffix
     * @return True if s2 matches the last s2.length() chars of s1
     */
    public static boolean isSuffix(String s1, String s2){
        if (!OPTIMIZE) {
            if (s2.length() > s1.length()) return false;
            else if (s2.length() == 0) return true;
            else if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1))
                return false;
            else return isSuffix(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length()));
        } else {
            return isSuffix(s1, s2, 0);
        }
    }

    /** Checks if s2 is suffix of s1
     * @param s1 Word with a suffix
     * @param s2 Suffix
     * @param i MUST be 0
     * @return True if s2 matches the last s2.lenght() chars of s1
     */
    public static boolean isSuffix(String s1, String s2, int i){
        if(s2.length() > s1.length()) return false;
        else if(i >= s2.length()) return true;
        else if(s2.charAt(s2.length() - 1 - i) != s1.charAt(s2.length() - 1 - i))
            return false;
        else return isSuffix(s1, s2, i + 1);
    }

    /**Checks more efficiently if s2 is contained in s1
     *
     * @param s1 String that contains
     * @param s2 String contained
     * @return True if s1 contains s2
     */
    public static boolean contains(String s1, String s2){
        if (!OPTIMIZE) {
            if (s1.length() < s2.length()) return false;
            else if (isPrefix(s1, s2)) return true;
            else return contains(s1.substring(1), s2);
        } else {
            return contains(s1, s2, 0);
        }
    }
    //TODO: fix contains method

    /**Checks more efficiently if s2 is contained in s1
     *
     * @param s1 String that contains
     * @param s2 String contained
     * @param i MUST be 0
     * @return True if s1 contains s2
     */
    public static boolean contains(String s1, String s2, int i){
        if(s1.length() < s2.length()) return false;
        else if(isPrefix(s1, s2, i)) return true;
        else return contains(s1, s2, i + 1);
    }
}
