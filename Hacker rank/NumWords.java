/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package numwords;

import java.util.Scanner;

/**
 *
 * @author samsung
 */
public class NumWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String s=sc.next();
      int l=s.length();
      int counter=0;
      char a[]=s.toCharArray();
      for(int i=0;i<=l-1;i++){
         if((int)a[i]>=65&&(int)a[i]<=91){
             
             counter++;

         }


      }


     System.out.print(counter+1);


    }

}
