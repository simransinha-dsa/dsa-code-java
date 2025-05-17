package com.simran.company.Google;

public class ContainerWithMostWater {
    // leetcode - 11
    public static void main(String[] args) {
        System.out.println(maxAreaOptimal(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxAreaOptimal(new int[] {1 , 1}));
    }

    public static int maxAreaOptimal(int[] nums) {
        int maxArea = 0;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int width = end - start;
            int area = Math.min(nums[start] , nums[end]) * width;
            maxArea = Math.max(maxArea , area);
            if(nums[start] < nums[end]) start++;
            else end--;
        }

        return maxArea;
    }


}
