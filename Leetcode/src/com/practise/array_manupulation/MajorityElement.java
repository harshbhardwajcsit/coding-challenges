
/*

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

Solution :
  runtime complexity : o(n^2)
  space complexity : o(1)
 */


package com.practise.array_manupulation;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        if(nums.length < 2){
            return nums[0];
        }

        int largestNum = 0;
        int maxCount = 0;

        for(int i =0; i< nums.length;i++){
            int count =0;
            for(int j =i;j< nums.length;j++){
                if(nums[i]==nums[j]){
                    count ++;
                }

                if(count>=maxCount){
                    maxCount = count;
                    largestNum = nums[i];
                }
            }
        }
        return largestNum;
    }
}
