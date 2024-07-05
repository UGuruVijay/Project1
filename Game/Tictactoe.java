package Game;
import java.util.*;
public class Tictactoe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] b = new char[3][3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = ' ';
            }
        }
        char P = 'X';
        boolean GO = false;
        while (!GO) {
            System.out.println("Enter" + P + "player");
            System.out.println("Enter positions");
            int i = s.nextInt();
            int j = s.nextInt();
            if (b[i][j] == ' ') {/*X | O | X
                                   X | X | O
                                   O | X | O*/
                b[i][j] = P;
                pB(b);
                GO = hasWon(P, b);
                if (GO) {
                    System.out.println(P + "has won");
                } else {
                    P = P == 'X' ? 'O' : 'X';
                }
            }
            else{
                System.out.println("invalid move");
            }
            if(Gamedraw(b)){
                System.out.println("Gamedraw");
                break;
            }
        }
        pB(b);

    }
    static boolean hasWon(char P, char[][] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i][0] == P && b[i][1] == P && b[i][2] == P) {
                return true;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[0][i] == P && b[1][i] == P && b[2][i] == P) {
                return true;
            }
        }
        if (b[0][0] == P && b[1][1] == P && b[2][2] == P) {
            return true;
        }
        if (b[0][2] == P && b[1][1] == P && b[2][0] == P) {
            return true;
        }
        return false;
    }
    static boolean Gamedraw(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    static void pB(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]+"|");
            }
            System.out.println();
        }
    }
}