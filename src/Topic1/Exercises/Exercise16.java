package Topic1.Exercises;

public class Exercise16 {

    public static int sumElements(int[] a){return sumElements(a, 0);}
    private static int sumElements(int[] a, int i){
        if(i >= a.length) return 0;
        else return a[i] + sumElements(a, i + 1);
    }

    public static int getMax(int[] a){return getMax(a, 0);}
    private static int getMax(int[] a, int i){
        if(i >= a.length) return Integer.MIN_VALUE;
        else return a[i] > getMax(a, i + 1) ? a[i] : getMax(a, i + 1) ;
    }

    public static int getMin(int[] a){return getMin(a, 0);}
    private static int getMin(int[] a, int i){
        if(i >= a.length) return Integer.MAX_VALUE;
        else return a[i] < getMin(a, i + 1) ? a[i] : getMin(a, i + 1);
    }

    public static int countAppearances(int[] a, int x){return countAppearances(a, x, 0);}
    private static int countAppearances(int[] a, int x, int i){
        if(i >= a.length) return 0;
        else return ((x == a[i]) ? 1 : 0) + countAppearances(a, x, i + 1);
    }

    public static boolean isOrdered(int[] a){return isOrdered(a, 0);}
    private static boolean isOrdered(int[] a, int i) {
        return i >= a.length || i == 0 || a[i] >= a[i - 1] && isOrdered(a, i + 1);
    }

    public static int firstNull(int[] a){return firstNull(a, 0);}
    private static int firstNull(int[] a, int i){
        if(i >= a.length) return -1;
        else if(a[i] == 0) return i;
        else return firstNull(a, i + 1);
    }

    public static int lastNull(int[] a){return lastNull(a, a.length - 1);}
    private static int lastNull(int[] a, int i){
        if(i < 0) return -1;
        else if(a[i] == 0) return i;
        else return lastNull(a, i - 1);
    }

    public static int countNullElementsAtEnd(int[] a){
        return countNullElementsAtEnd(a, a.length - 1);
    }
    private static int countNullElementsAtEnd(int[] a, int i){
        if(i < 0) return 0;
        else if(a[i] != 0) return 0;
        else return 1 + countNullElementsAtEnd(a, i - 1);
    }

    public static void invertBetween(int[] a, int left, int right){
        if(!(left < 0 || left >= right || right >= a.length))
            invertBetweenP(a, left, right);
    }
    private static void invertBetweenP(int[] a, int left, int right){
        if(left < right){
            int aux = a[left];
            a[left] = a[right];
            a[right] = aux;
            invertBetweenP(a, left + 1, right - 1);
        }
    }

    public static void duplicateBetween(int[] a, int left, int right){
        if(!(left < 0 || left >= right || right >= a.length))
            duplicateBetweenP(a, left, right);
    }
    private static void duplicateBetweenP(int[] a, int left, int right){
        if(left < right){
            a[left] *= 2;
            a[right] *= 2;
            duplicateBetweenP(a, left + 1, right - 1);
        }
    }

    public static boolean sumEquals(int[] a, int b){return b == sum(a, a.length - 1);}
    private static int sum(int[] a, int i){
        if(i == 0) return a[0];
        else return a[i] + sum(a, i - 1);
    }

    public static int elementsBelowX(int[] a, int x){return elementsBelowX(a, x, a.length - 1);}
    private static int elementsBelowX(int[] a, int x, int i){
        if(i == 0) return a[0] < x ? 1 : 0;
        else return (a[i] < x ? 1 : 0) + elementsBelowX(a, x, i - 1);
    }

    public static int oddElementsEvenIndexes(int[] a){return oddElementsEvenIndexes(a, a.length % 2 == 0 ? a.length - 2 : a.length - 1);}
    private static int oddElementsEvenIndexes(int[] a, int i){
        if(i == 0) return a[0] % 2 != 0 ? 1 : 0;
        else return (a[i] % 2 != 0 ? 1 : 0) + oddElementsEvenIndexes(a, i - 2);
    }

    public static int consecutiveSequence(int[] a){return consecutiveSequence(a, 0);}
    private static int consecutiveSequence(int[] a, int i){
        if(i + 2 >= a.length) return -1;
        else if(a[i] + 1 == a[i + 1] && a[i + 1] + 1 == a[i + 2]) return i;
        else return consecutiveSequence(a, i + 1);
    }
}