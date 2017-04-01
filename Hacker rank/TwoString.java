/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twostring;

import java.util.*;
public class TwoString {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String string="harsh";
       String string1="hello";

       char a[]=string.toCharArray();
       char b[]=string1.toCharArray();

       int i;
       Map<Character,Character> map=new HashMap<Character,Character>();
       for(i=0;i<b.length;i++){

       map.put(b[i],b[i]);


       }
           int result=0;
        for(i=0;i<a.length;i++){


       if(map.containsKey(a[i])==true){result=1;}

       }

          


       if(result==1){System.out.print("common substring exits");}
       else{System.out.print("common substring not exits");}



    }

}
