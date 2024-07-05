package Game;
import java.util.*;
public class DiceSum {
    public static void main(String[] args) {
        ArrayList<String> l=diceSum("",3,9);
        System.out.println(l);
    }
    static ArrayList<String> diceSum(String P,int t,int face){
        ArrayList<String> l=new ArrayList<>();
        if(t==0){
            l.add(P);
            return l;
        }
        for(int i=1;i<=t&&i<=face;i++){
            l.addAll(diceSum(P+i,t-i,face));
        }
        return l;
    }
}
