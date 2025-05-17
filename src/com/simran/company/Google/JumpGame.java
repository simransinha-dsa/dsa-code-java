package com.simran.company.Google;

public class JumpGame {
    // leetcode - 55
    public static void main(String[] args) {
        System.out.println(jumpGame(new int[] {2 ,3 , 1 ,1 , 4}));
        System.out.println(jumpGame(new int[] {3 , 2 , 1 , 0 , 4}));  
    }

    public static boolean jumpGame(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 0 ; i < n ; i++) {
            dp[i] = -1;
        }

        return solve(nums , n , 0 , dp);
    }

    public static boolean solve(int[] nums , int n , int index , int[] dp) {
        if(index >= n - 1) return true;

        if(dp[index] != -1) {
            if(dp[index] == 1) return true;
            else return false;
        }

        for(int i = 1 ; i <= nums[index]; i++) {
            if(solve(nums , n , index + 1 , dp)) {
                dp[index] = 1;
                return true;
            } else {
                dp[index] = 0;
            }
        }
        return false;
    }
 }
