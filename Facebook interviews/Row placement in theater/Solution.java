/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {

    boolean function(int a[],int val){

    if(a[0]==0){ if(a[1]!=1){val--;}}
    if(a[a.length-1]==0){if(a[a.length-2]!=1){val--;}}

    int j=a.length;
    while(j>0){
    if(a[j]==0){if(a[j-1]!=1&&a[j+1]!=1){val--;}}

    j--;

    }

    if(val==0){return true;}
    else{return false;}



    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
          array[i]=sc.nextInt();

        }

        int person=sc.nextInt();
        if(solution.function(array, person)==true){System.out.println("possible");}
        else{System.out.println("Not possible");}

    }

}
