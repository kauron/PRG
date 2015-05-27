package TxusExtra.Exercises;

public class Deliverable1 {
    public static double average(double A[]) {
        double sum = 0.0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum / A.length;
    }

    public static int maximum(int V[]) {
        int max = V[0];
        for (int i = 1; i < V.length; i++) {
            if (V[i] > max) max = V[i];
        }
        return max;
    }

    public static int scalarProduct(int A[], int B[]) {
        // Testing size equality: A.length == B.length
        if (A.length != B.length) {
            System.err.println("Impossible computing the scalar product "
                    + "of two different vectors.");
            return 0;
        }

        int product = 0;
        for (int i = 0; i < A.length; i++) {
            product += A[i] * B[i];
        }
        return product;
    }
}

