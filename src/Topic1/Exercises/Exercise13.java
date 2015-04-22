package Topic1.Exercises;

public class Exercise13{

    public static void printPascal(int r){
        for(int row = 0; row < r; row++){
            for(int col = 0; col <= row; col++){
                System.out.printf(" %d", pascalTriangle(row, col));
            }
            System.out.println();
        }

    }
    public static int pascalTriangle(int row, int col){
        if (row == col || col == 0) return 1;
        else return pascalTriangle(row - 1, col) + pascalTriangle(row - 1, col - 1);
    }
}
