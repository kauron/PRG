package Topic1.Exercises;

/**
 * Created by Carlos on 11/02/2015.
 */
public class Exercise14 {
    public static int sumav(int[] v, int i, int x){
        int suma = 0;
        if(i<0) return suma;
        if(v[i]==x) return suma;
        for(int j=0; j<=i; j++)
            suma += v[j];
        System.out.println("Suma parcial: " + suma);
        return suma + sumav(v, i-1, x);
    }
}
