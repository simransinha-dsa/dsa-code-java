package com.simran.company.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // leetcode - 15
    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});

        for(List<Integer> triplets: result) {
            for(int num: triplets) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < right && nums[left - 1] == nums[left]) left++;
                } else if(nums[i] + nums[left] + nums[right] < 0) left++;
                else right--;
            }
        }

        return result;
    }
}
