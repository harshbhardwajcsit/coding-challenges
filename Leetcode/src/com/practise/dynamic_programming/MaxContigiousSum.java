package com.practise.dynamic_programming;

    /*
Kadane Algorithm
Initialize:
        max_so_far = 0
        max_ending_here = 0

        Loop for each element of the array
        (a) max_ending_here = max_ending_here + a[i]
        (b) if(max_so_far < max_ending_here)
        max_so_far = max_ending_here
        (c) if(max_ending_here < 0)
        max_ending_here = 0
        return max_so_far

*/

    public class MaxContigiousSum {

        public static int findSum(int[] arr) {

            int max_so_far = arr[0];
            int max_ending = 0;
            for (int j : arr) {
                max_ending = max_ending + j;
                if (max_ending < 0) {
                    max_ending = 0;
                } else if (max_ending > max_so_far) {
                    max_so_far = max_ending;
                }
            }
            return max_so_far;
        }

        public static void main(String[] args) {
            int[] arr1 = {2, -3, 4, -1, -2, 1, 5, -3};
            int[] arr2 = {1 ,2 ,3 ,-2, 5};
            System.out.println(MaxContigiousSum.findSum(arr1));
            System.out.println(MaxContigiousSum.findSum(arr2));
        }
    }

