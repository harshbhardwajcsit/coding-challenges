package com.practise.array_manupulation;
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

        Example 1:

        Input: [3,0,1]
        Output: 2
        Example 2:

        Input: [9,6,4,2,3,5,7,0,1]
        Output: 8
        Note:
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

public class MissingNumbers {
    public int missingNumber(int[] nums) {

        int actualSum = 0;
        int largest=0;
        int expectedSum =0;


        for (int i=0;i< nums.length;i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
        }

        if(nums.length > largest) {
            expectedSum = nums.length*(nums.length +1)/2;
        }else{
            expectedSum = largest*(largest + 1)/2;
        }



        for (int i=0;i< nums.length;i++){
            actualSum = actualSum + nums[i];
        }

        return expectedSum - actualSum;
    }
}
