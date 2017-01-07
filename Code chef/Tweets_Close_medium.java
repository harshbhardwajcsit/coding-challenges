/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication65;
import java.util.*;
import java.io.*;
/**
 *
 * @author samsung
 */
public class Tweets_Close_medium{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int test=sc.nextInt();
		int open=0;
		Map<String,String> map=new HashMap<String,String>();
		while(test>0){

			String st=sc.nextLine();
                        String s="CLOSEALL";
			if(st.compareTo(s)==0){
			map.clear();
			open=0;
			System.out.println("OPEN"+open);
			}
			else{
				if(map.containsKey(st)==false){
				map.put(st,st);
				open++;
				System.out.println("OPEN :"+open);
				}
				if(map.containsKey(st)==true){
					open--;
				System.out.println("OPEN :"+open);

				}
			}


			test--;
		}

    }

}
