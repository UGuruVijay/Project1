package Game;

public class NKnights {
    public static void main(String[] args) {
        int n=5;
        boolean[][] b=new boolean[n][n];
        System.out.println(queens(b,0));
    }
    static int queens(boolean[][] b,int r){
        if(r==b.length){
            display(b);
            System.out.println();
            return 1;
        }
        int C=0;
        for(int c=0;c<b[0].length;c++) {
            if (isSafe(b, r, c)) {
                b[r][c] = true;
                C += queens(b, r + 1);
                b[r][c] = false;
            }
        }
        return C;
    }
    static boolean isSafe(boolean[][]b,int r,int c){
        if(isValid(b,r-2,c-1)) {
            if (b[r - 2][c - 1]) {
                return false;
            }
        }
        if(isValid(b,r-2,c+1)) {
            if (b[r - 2][c + 1]) {
                return false;
            }
        }
        if(isValid(b,r-1,c-2)) {
            if (b[r - 1][c - 2]) {
                return false;
            }
        }
        if(isValid(b,r-1,c+2)) {
            if (b[r - 1][c + 2]) {
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] b,int r,int c){
        if(r>=0&&r<b.length&&c>=0&&c<b[0].length){
            return true;
        }
        return false;
    }
    static void display(boolean[][] b){
        for(boolean[] r:b){
            for(boolean e:r){
                if(e){
                    System.out.print("K|");
                }
                else{
                    System.out.print("X|");
                }
            }
            System.out.println();
        }
    }
}
