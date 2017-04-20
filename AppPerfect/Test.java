

find the isomorphic pairs of string !! 

a string is said to be isomorphic if its each alphabets can be replaced by another alphabet

for ex "abca" and  "zxyz" are isomorphic but "abca" and "pqrs" is not isomorphic

conditions :
1 - A character can be replaced by itself. for ex   "abcd" and "pbfg" are isomorphic .
2- No two characters can be replaced by same character . for ex "abcd" and "bbcd" are not isomorphic .





/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {


    int IsApm(String st1,String st2){
        int result=1;
         char a1[]=st1.toCharArray();
         char a2[]=st2.toCharArray();
         Map<Character,Character> map=new HashMap<Character,Character>();
         for(int k=0;k<a1.length;k++){
           if(map.containsKey(a1[k])==false){
                if(map.containsValue(a2[k])==false){

                map.put(a1[k],a2[k]);}
                else{
                result=0;
                }
           }

           else{
              if(map.get(a1[k])==a2[k]){}
              else{result=0;}

           }
          }

        return result;
    }

    public static void main(String[] args) {
        Test t=new Test();
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test>0){
        int N=sc.nextInt();
        String st[]=new String[N];
        int i,j;
        for(i=0;i<N;i++){
            st[i]=sc.next();   //taking the string inputs
        }
        int counter=0;
        for(i=0;i<N-1;i++){
        for(j=i+1;j<N;j++){


           if(t.IsApm(st[i],st[j])==1){
               counter++;
           }


        }
        }

        System.out.println(counter);

        test--;
        }
    }

}
