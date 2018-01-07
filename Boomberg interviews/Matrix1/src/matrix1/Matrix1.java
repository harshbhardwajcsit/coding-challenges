/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package matrix1;

import java.util.*;
import java.lang.*;
public class Matrix1 {

   static int N=4,M=5;
  
     static int matrixx[][] = {{1, 1, 2 , 5, 6},
		       	 {4, 7, 7 ,1 ,3},
			 {2, 3, 4,5,6},
                         {9, 8, 7,6,4}};

    void decreament_of_I(int x,int y){
        int i=x,j=y;
        if(x<N&&y<=M){
        while(x>=j){
        System.out.print(matrixx[x][y]);
        y++;
        x--;
       }
        if(y<M){Increament_of_I(j, y+1);}
        else{Increament_of_I(x+1, y);}

        }
        else{}}



    void Increament_of_I(int x,int y){
        int i=x,j=y;
        if(x<N&&y<=M){
        while(y>=i){
        System.out.print(matrixx[x][y]);
        x++;
        y--;

        }
        if(y==0){decreament_of_I(x+1, i);}
        else{decreament_of_I(x, y+1);}

        }
        else{}
    }
    
    public static void main(String[] args) {
        Matrix1 matrix=new Matrix1();
         Scanner sc=new Scanner(System.in);
         

      

        System.out.print(matrixx[0][0]);
        matrix.Increament_of_I(0, 1);
        
    }

}
