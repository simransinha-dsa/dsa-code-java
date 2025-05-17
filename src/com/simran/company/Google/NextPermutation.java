package com.simran.company.Google;

import java.util.Arrays;

public class NextPermutation {
    // leetcode - 31

    public static void main(String[] args) {
        int[] num = new int[] {3 ,2 ,1};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = -1;

        for(int i = n - 1 ; i > 0 ; i--) {
            if(nums[i-1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums , 0);
            return;
        }

        for(int i = n-1 ; i >= 0 ; i--) {
            if(nums[i] > nums[pivot]) {
                swap(nums , pivot , i);
                break;
            }
        }

        reverse(nums , pivot + 1);
    }

    public static void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while(start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
