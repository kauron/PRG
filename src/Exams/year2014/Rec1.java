package Exams.year2014;


public class Rec1 {
    public static boolean startOfFib (int[] a, int pos) {
        if (pos == a.length ) return true;
        else if ( pos >= 2 )
            return ( a[pos] == 1 && a[pos - 1] == 1 && a[pos - 2] == 0 ) || startOfFib(a, pos + 1);
        else return a[0] == 0 && a[1] == 1 && a[2] == 1 || startOfFib(a, 3);
    }
}
