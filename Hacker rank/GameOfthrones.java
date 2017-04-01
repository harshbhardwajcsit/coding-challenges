/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gameofthrones;

import java.util.*;
public class GameOfthrones {

   int ispal(String string){
   int result=0;
   StringBuffer stb=new StringBuffer(string);
   if(stb.equals(stb.reverse())){

       result=1;
   }

   return result;

   }
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     GameOfthrones g=new GameOfthrones();
     String string=sc.next();
     String st=string+string;
     System.out.print(st);
     char a[]=st.toCharArray();
     int i,final_result=0;
     for(i=0;i<=string.length();i++){

     if(g.ispal(st.substring(i, i+(string.length()+1)))==1){
         final_result=1;
     }

     }



    System.out.print(final_result);

    
    }

}
