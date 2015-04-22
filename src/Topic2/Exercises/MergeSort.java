package Topic2.Exercises;


public class MergeSort {
    public static void main (String[] args){

    }

    static int[] mergeSort (int[] A) {
        mergeSort(A, 0, A.length);
        return A;
    }

    static void mergeSort (int[] A, int left, int right) {
        if(left < right) {
            mergeSort(A, left, (left + right) / 2);
            mergeSort(A, (left + right) / 2 + 1, right);
            naturalMerge(A, left, (left + right) / 2, right);
        }
    }

    static void naturalMerge(int[] V, int left, int half, int right) {
        int aux[] = new int[right - left + 1];
        int a = left, b = half + 1, c = 0;

        while (a <= half && b <= right)
            if (V[a] < V[b]) aux[c++] = V[a++];
            else aux[c++] = V[b++];

        while (a <= half) aux[c++] = V[a++];
        while (b <= right) aux[c++] = V[b++];

        for(int i = 0; i < aux.length; i++) V[left + i] = aux[i];
    }
}
