package com.simran.leetcode.Blind75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    public static void main(String[] args) {
        List<List<Integer>> results = threeSum(new int[] {0,1,1});
        for(List<Integer> list: results) {
            for(int i = 0 ; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /*
         * List of Integers of three elements that sums to 0
         */
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue; // to remove duplicates
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    results.add(List.of(nums[i] , nums[left] , nums[right]));
                    left++;
                    while(left < right && nums[left - 1] == nums[left]) left++; // to remove duplicates
                } else if(nums[i] + nums[left] + nums[right] < 0) left++;
                else right--;
            }
        }
        return results;
    }
}
