package com.simran.company.Amazon;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simransinha
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    swap(nums , mid , low);
                    mid++;
                    low++;
                }
                case 1 -> mid++;
                default -> {
                    swap(nums , mid , high);
                    high--;
                }
            }
        }
    }

    public static void swap(int[] nums , int start , int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
