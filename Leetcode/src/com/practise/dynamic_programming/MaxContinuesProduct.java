package com.practise.dynamic_programming;

public class MaxContinuesProduct {

    public static int getMaxProduct(int[] arr) {
        int max_so_far = arr[0];
        int max_product = arr[0];
        for (int j = 1 ; j< arr.length ; j++) {
            if ((max_so_far > 0 && arr[j] > 0) || (max_so_far < 0 && arr[j] < 0)) {
                max_so_far = max_so_far * arr[j];
                if (max_so_far > max_product) {
                    max_product = max_so_far;
                }
            } else {
                max_so_far = arr[j];
            }
        }

        if (max_so_far > max_product) {
            max_product = max_so_far;
        }
        return max_product;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4 , -4 , -4};
        System.out.println(MaxContinuesProduct.getMaxProduct(arr));
    }
}

