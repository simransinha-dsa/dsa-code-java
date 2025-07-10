package com.simran.company.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    // leetcode - 163
    /*
     * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, 
     * where all elements are within the inclusive range.
     * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
     * Return the shortest sorted list of ranges that exactly covers all the missing numbers. 
     * That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
     */

     public static void main(String[] args) {
        List<List<Integer>> result = missingRanges(new int[] {0 , 1 ,3 , 50 , 75}, 0, 99);

        for(List<Integer> list: result) {
            for(int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
     }

     public static List<List<Integer>> missingRanges(int[] nums , int lower , int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // check lower range
        if(lower < nums[0]) {
            result.add(Arrays.asList(lower , nums[0] - 1));
        }

        // check middle ranges
        for(int i = 0 ; i < n-1 ; i++) {
            if(nums[i+1] - nums[i] > 1) {
                result.add(Arrays.asList(nums[i] + 1 , nums[i+1] - 1));
            }
        }

        // check upper range
        if(nums[n -1] < upper) {
            result.add(Arrays.asList(nums[n-1] + 1 , upper));
        }

        return result;
     }
}
