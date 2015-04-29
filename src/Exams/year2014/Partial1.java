package Exams.year2014;

public class Partial1 {
    public static int sumaCapicua (int[] a) {
        return sumaCapicua(a, 0, a.length - 1);
    }

    public static int sumaCapicua (int[] a, int begin, int end) {
        if (begin == end) return a[begin];
        else if (begin < end && a[begin] == a[end]) return a[begin]*2 + sumaCapicua(a, begin+1, end-1);
        else return 0;
    }

    public static boolean progAritmetica (int[] a, int d, int pos) {
        return pos == a.length - 1
                || (a[pos + 1] == a[pos] + d) && progAritmetica(a, d, pos + 1);
    }

    public static int triangulo (int h) {
        int cont = 0;
        for (int c1 = 4; c1 < h; c1++)
            for (int c2 = 3; c2 < c1; c2++)
                if (c1*c1 + c2*c2 == h*h) {
                    cont++;
                    System.out.println(c1 + " " + c2);
                }
        return cont;
    }
}
