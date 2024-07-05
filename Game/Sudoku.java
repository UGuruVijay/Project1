package Game;

public class Sudoku {
    public static void main(String[] args) {
         int[][] b={   {0, 2, 7, 5, 6, 8, 0, 9, 0},
                 {0, 0, 0, 0, 0, 7, 5, 0, 4},
                 {0, 0, 5, 3, 4, 0, 0, 0, 7},
                 {1, 0, 0, 6, 0, 5, 7, 4, 0},
                 {5, 0, 8, 7, 3, 0, 0, 0, 2},
                 {7, 0, 0, 2, 0, 0, 3, 5, 0},
                 {0, 4, 0, 0, 0, 1, 0, 7, 0},
                 {8, 0, 0, 9, 0, 6, 4, 3, 0},
                 {0, 0, 6, 4, 7, 0, 0, 0, 0} };
         if(solve(b)){
             display(b);
         }
         else{
             System.out.println("not solve");
         }
    }
    static boolean solve(int[][] b){
         int r=-1;
         int c=-1;
         boolean el=false;
         for(int i=0;i<b.length;i++){
             for(int j=0;j<b[0].length;j++){
                 if(b[i][j]==0){
                     r=i;
                     c=j;
                     el=true;
                     break;
                 }
             }

         }
         if(el==false){
             return true;
         }
         for(int num=1;num<=9;num++){
             if(isSafe(b,r,c,num)){
                 b[r][c]=num;
                 if(solve(b)){
                     return true;
                 }
                 else{
                     b[r][c]=0;
                 }
             }
         }
            return false;
    }
    static void display(int[][] b){
            for(int[] r:b){
                for(int n:r){
                    System.out.print(n+" ");
                }
                System.out.println();
            }
    }
    static boolean isSafe(int[][] b, int r, int c, int n) {
        for (int i = 0; i < b[0].length; i++) {
            if (b[r][i] == n) {
                return false;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i][c] == n) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(b.length);
        int rs = r - r % sqrt;
        int cs = c - c % sqrt;
        for (int i = rs; i < rs + sqrt; i++) {
            for (int j = cs; j < cs + sqrt; j++) {
                if (b[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
