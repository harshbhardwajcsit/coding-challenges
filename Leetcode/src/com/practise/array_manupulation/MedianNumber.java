package com.practise.array_manupulation;

public class MedianNumber {

    public static double getMedian(int[] num1, int[] num2){
        int len = Math.max(num1.length, num2.length);
        int[] arr = new int[num1.length + num2.length];
        for(int i = 0; i < len; i++){
            int lastIndex = i*2  - 1;
            int r = num1[i];
            int p = num2[i];
            if(i==0){
                if(r > p){
                    arr[i] = p;
                    arr[i+1] = r;
                }else {
                    arr[i] = r;
                    arr[i+1] = p;
                }
            }else {
                if(r > p){
                    if(arr[lastIndex] > p){
                        int temp = arr[lastIndex];
                        arr[lastIndex] = p;
                        arr[i] = temp;
                        arr[i+1] = r;
                    }else {
                        arr[i] = p;
                        arr[i+1] = r;
                    }
                }else {
                    if(arr[lastIndex] > r){
                        int temp = arr[lastIndex];
                        arr[lastIndex] = r;
                        arr[i] = temp;
                        arr[i+1] = p;
                    }else {
                        arr[i] = r;
                        arr[i+1] = p;
                    }
                }
            }
        }


        return arr.length%2==0? (arr[arr.length/2] + arr[arr.length/2-1])/2 : arr[(arr.length -1)/2];
    }

    public static void main(String[] args) {
        MedianNumber.getMedian(new int[] {4,7,8}, new int[]{1,3});
    }
}
