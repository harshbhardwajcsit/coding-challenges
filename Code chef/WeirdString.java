/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package weirdstring;

import java.util.Scanner;

/**
 *
 * @author samsung
 */
public class WeirdString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.next();
        char ar[]=st.toCharArray();
        int l=ar.length;
        //System.out.println(l);
        int i=0;
        String stb=new String("");
        while(i<=l-2){
            int x=0;
            int y=ar[i+1]-'0';
            
            while(x<y){

            stb=stb+ar[i];
             x++;

            }
             
i=i+2;

        }
        System.out.println(stb);

    }

}
