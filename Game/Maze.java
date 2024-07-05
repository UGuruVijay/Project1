package Game;

import java.util.*;

public class Maze {
    public static void main(String[] args) {
        boolean[][] m={{true,true,true},{true,true,true},{true,true,true}};
        int[][] p=new int[m.length][m[0].length];
        allPath("",m,p,1,0,0);
    }
    static void allPath(String P,boolean[][] m,int[][] p,int S,int r,int c) {
          if(r==m.length-1&&c==m[0].length-1){
              p[r][c]=S;
              for(int[] a:p){
                  System.out.println(Arrays.toString(a));
              }
              System.out.println(P);
              return;
          }
          if(!m[r][c]){
              return;
          }
          m[r][c]=false;
          p[r][c]=S;
          if(r<m.length-1){
              allPath(P+'D',m,p,S+1,r+1,c);
          }
        if(c<m[0].length-1){
            allPath(P+'R',m,p,S+1,r,c+1);
        }
        if(r>0){
            allPath(P+'U',m,p,S+1,r-1,c);
        }
        if(c>0){
            allPath(P+'L',m,p,S+1,r,c-1);
        }
        m[r][c]=true;
        p[r][c]=0;

    }
    }
