/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package winplayer;

import java.util.Scanner;
import java.util.TreeMap;


public class WinPlayer {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeMap<Integer,Integer> tmap=new TreeMap<Integer,Integer>();
        int rounds=sc.nextInt();
        int p1,p2;
        while(rounds>0){
         p1=sc.nextInt();
         p2=sc.nextInt();
         if(p1>p2){tmap.put(p1-p2,1);}
         else{
            
         tmap.put(p2-p1,2);
         }



            rounds--;
       


 }
          System.out.print(tmap.get(tmap.lastKey())+" "+tmap.lastKey());

    }

}
