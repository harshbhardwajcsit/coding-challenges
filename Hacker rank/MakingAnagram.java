/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package makinganagram;
import java.util.*;
public class MakingAnagram {

 
    public static void main(String[] args) {
        String string1="cde";
        String string2="abc";
        
        char st1[]=string1.toCharArray();
        char st2[]=string2.toCharArray();


        Map<Character,Integer> map1=new HashMap<Character,Integer>();
        int i;
        for(i=0;i<st1.length;i++){
        if(map1.containsKey(st1[i])==false){
            map1.put(st1[i],1);
        }
        else{

             map1.put(st1[i],map1.get(st1[i])+1);

        }
        }

          System.out.print("map1 : "+map1+"\n");

        Map<Character,Integer> map2=new HashMap<Character,Integer>();
          for(i=0;i<st2.length;i++){
        if(map2.containsKey(st2[i])==false){
            map2.put(st2[i],1);
        }
        else{

             map2.put(st2[i],map2.get(st2[i])+1);

        }
        }

        System.out.print("map2 : "+map2+"\n");

        int counter1=0;
        for(Map.Entry<Character,Integer> entry : map1.entrySet()){

        char key=entry.getKey();
        int value=entry.getValue();

        if(map2.containsKey(key)==false){

        counter1++;
        }
        else{

        int value1=map2.get(key);
        if(value1>value){map2.put(key, value);
        counter1=counter1+Math.abs(value1-value);}
        else{
        map1.put(key, value1);
        counter1=counter1+Math.abs(value-value1);
        }
        }
        }

      
     


         
         for(Map.Entry<Character,Integer> entry1 : map2.entrySet()){

        char key=entry1.getKey();
        int value=entry1.getValue();

        if(map1.containsKey(key)==false){

        counter1++;
        }
        else{

        int value1=map1.get(key);
        if(value1>value){map1.put(key, value);
        counter1=counter1+Math.abs(value1-value);}
        else{
        map2.put(key, value1);
        counter1=counter1+Math.abs(value-value1);
        }
        }
        }

       
        
        System.out.print(counter1);



    }

}
