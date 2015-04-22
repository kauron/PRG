package Topic2.Exercises;

import java.util.*;
import java.io.*;

public class Deliverable1_6{
    public static void main( String args[] ){
        int A[] = loadFromFile( "fichero1.txt" );
        int B[] = loadFromFile( "fichero2.txt" );
        sort( A );
        sort( B );
        int C[] = naturalMerge( A, B );
        saveToFile( "fichero3.txt", C );
    }

    static int [] loadFromFile( String fileName ){
        int V[] = null;
        try {
            Scanner sf = new Scanner( new File( fileName ) );
            int n = sf.nextInt();
             V = new int [n];
            int i=0;
             while( sf.hasNext() ) {
                V[i++] = sf.nextInt();
                }
             sf.close();
        } catch( IOException ioe ){
            ioe.printStackTrace( System.err );
            System.exit(-1);
        }

            return V;
        }
    static void saveToFile( String fileName, int V[] ){
        try {
            PrintWriter pw = new PrintWriter( new File( fileName ) );
            pw.println( V.length );
            for( int i=0; i < V.length; i++ ) pw.print( V[i] + " " );
            pw.close();
        } catch( IOException ioe ){
            ioe.printStackTrace( System.err );
            System.exit(-1);
        }
    }

    static void sort( int V[] ){
        for(int i = 1; i < V.length; i++){
            int x = V[i], j = i;
            while(j > 0 && x < V[j - 1]) {
                V[j] = V[j - 1]; j--;
            }
            V[j] = x;
        }
    }

    static int [] naturalMerge( int A[], int B[] ){
        int[] C = new int[A.length + B.length];
        int a = 0, b = 0, c = 0;

        while(a < A.length && b < B.length)
            if(A[a] > B[b]) C[c++] = B[b++];
            else C[c++] = A[a++];

        while(a < A.length) C[c++] = A[a++];
        while(b < B.length) C[c++] = B[b++];

        return C;
    }
}