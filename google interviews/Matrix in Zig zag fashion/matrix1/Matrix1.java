/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package matrix1;

import java.util.*;
import java.lang.*;
public class Matrix1 {

   static int N,M;
   static  int matrixx[][]=new int[N][M];
    void decreament_of_I(int x,int y){
        int i=x,j=y;
        if(x<N&&y<=M){
        while(x>=j){
        System.out.print(matrixx[x][y]);
        y++;
        x--;
       }
        if(y<4){Increament_of_I(j, y+1);}
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
         N=sc.nextInt();
         M=sc.nextInt();


        for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
        matrixx[i][j]=sc.nextInt();


        }}
        System.out.print(matrixx[0][0]);
        matrix.Increament_of_I(0, 1);
        
    }

}
