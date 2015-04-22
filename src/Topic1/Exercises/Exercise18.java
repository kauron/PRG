package Topic1.Exercises;

public class Exercise18 {
    public static boolean capicua(String[] v){
        return capicua(v, 0, v.length - 1);
    }
    public static boolean capicua(String[] v, int begin, int end){
        if(begin >= end) return true;
        else if(v[begin].equals(v[end])) return capicua(v, begin + 1, end - 1);
        else return false;
    }

    public static int findPosition(String[] v, String pal, int ini, int fin){
        if(ini < 0 || ini > fin || fin >= v.length) return -1;
        else if(pal.equals(v[ini])) return ini;
        else if(pal.equals(v[fin])) return fin;
        else return findPosition(v, pal, ini + 1, fin - 1);
    }
}