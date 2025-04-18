/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simransinha
 */
public class MaximumSubArray{

    public static void main(String[] args) {
        System.out.println(maximumSubArrayBruteForce(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, }));
        System.out.println(maximumSubArrayOptimal(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, }));
    }

    // Brute Force 
    // O(n2)

    public static int maximumSubArrayBruteForce(int[] nums) {
        int n = nums.length;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++) {
            int currentSum = 0;
            for(int j = i ; j < n; j++) {
                currentSum += nums[j];
                max_sum = Math.max(max_sum, currentSum);
            }
        }
        return max_sum;
    }

    // Optimal 
    // Kadane's Algorithm
    //O(n)

    public static int maximumSubArrayOptimal(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum , maxSum);
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }
}
