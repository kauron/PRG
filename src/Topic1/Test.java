package Topic1;

import Topic1.Lab2.Part1;

public class Test {
    public static void main(String[] args){
        //TODO: fix
        String p = "Se dice detrás: a casar te decides.";
        String cont = "detrás";
        String cont2 = "detras";
        System.out.printf("%s is contained in %s\n%s\n", cont, p, Part1.contains(p, cont));
        System.out.printf("%s is contained in %s\n%s\n", cont2, p, Part1.contains(p, cont2));
    }
}
