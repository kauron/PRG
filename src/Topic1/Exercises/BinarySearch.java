package Topic1.Exercises;

public class BinarySearch {
    public static int iterative(int A[], int x){
        int left = 0, right = A.length - 1, k;

        while(left <= right){
            k =  (left + right) / 2;

            if(A[k] == x) return k;
            else if(A[k] > x) left = k + 1;
            else right = k - 1;
        }

        return -1;
    }

    public static int recursiveP(int A[], int x, int left, int right) {
        if (left > right) return -1;
        int k = (right + left) / 2;
        if (A[k] == x) return k;
        else if (A[k] > x)
            return recursiveP(A, x, k + 1, right);
        else
            return recursiveP(A, x, left, k - 1);
    }
}
