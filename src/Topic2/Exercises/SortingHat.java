package Topic2.Exercises;

public class SortingHat {
    public static void selectionSort (int[] v) {
        for(int i = 0; i < v.length; i++){
            int min = i;
            for(int j = i; j < v.length; j++){
                //look for the minimum value in the unsorted part
                min = min < v[j] ? min : j;
            }
            if(min != i) fancySwap(v, min, i);
        }
    }

    public static void swap(int[] v, int a, int b){
        int temp = v[a];
        v[a] = v[b];
        v[b] = temp;
    }

    public static void fancySwap(int[] v, int a, int b){
        v[a] = v[a] + v[b];
        v[b] = v[a] - v[b];
        v[a] = v[a] - v[b];
    }

    public static void insertionSort (int[] v){
        for(int i = 1; i < v.length; i++){
            int x = v[i], j = i;
            while(j > 0 && x < v[j - 1]) {
                v[j] = v[j - 1]; j--;
            }
            v[j] = x;
        }
    }

    public static void bubbleSort (int[] v) {
        for(int i = 0; i < v.length; i++) { //to get the first n values change v.length
            for(int j = v.length; j > i; j--) {
                if (v[j] < v[j - 1]) swap(v, j, j - 1);
            }
        }
    }
}
