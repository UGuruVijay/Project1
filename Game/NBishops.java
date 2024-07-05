package Game;

public class NBishops {
        public static void main(String[] args) {
            int n=3;
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
            int ml=Math.min(r,c);
            for(int i=1;i<=ml;i++){
                if(b[r-i][c-i]){
                    return false;
                }
            }
            int mr=Math.min(r,b.length-1-c);
            for(int i=1;i<=mr;i++){
                if(b[r-i][c+i]){
                    return false;
                }
            }
            return true;
        }
        static void display(boolean[][] b){
            for(boolean[] r:b){
                for(boolean e:r){
                    if(e){
                        System.out.print("B|");
                    }
                    else{
                        System.out.print("X|");
                    }
                }
                System.out.println();
            }
        }
    }
