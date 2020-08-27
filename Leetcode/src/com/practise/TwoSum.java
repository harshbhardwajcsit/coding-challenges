package com.practise;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static Integer[] twoSum(int[] nums, Integer target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i< nums.length ;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        Integer array[] = new Integer[2];

        for (Map.Entry<Integer,Integer> entry : map.entrySet())  {

            int key = entry.getKey();
            if(map.containsKey(target - key)){

                array[0] = map.get(key);
                array[1] = map.get(target-key);
            }
        }
          return array;
    }

    public static void main(String[] args) {
        TwoSum.twoSum(new int[]{2, 7, 11, 15},9);
    }
}
