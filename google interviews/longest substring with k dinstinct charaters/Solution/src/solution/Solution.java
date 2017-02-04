/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
 Map<Character,Integer> map=new HashMap<Character,Integer>();
 Boolean function(String string,int kval){



 char array[]=string.toCharArray();
 for(int i=0;i<array.length;i++){
   if(map.containsKey(array[i])==false){map.put(array[i],1);}
   }
 if(map.size()==kval){
     map.clear();
 return true;
 }
 else{
     map.clear();
 return false;}


 }

 Set<String> Hash = new HashSet<String>();

    void getSubstring(String strng,int Kval){
        if(function(strng, Kval)==true){Hash.add(strng);}
        else{
         String st1=strng.substring(0,strng.length()-1);
         String st2=strng.substring(1,strng.length());

         getSubstring(st1, Kval);
         getSubstring(st2, Kval);
        }

        }
void showSet(){

System.out.println(Hash);
}


   
    public static void main(String[] args) {
        Solution solution=new Solution();
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        String st=sc.next();
        solution.getSubstring(st, k);

        solution.showSet();




    }

}
