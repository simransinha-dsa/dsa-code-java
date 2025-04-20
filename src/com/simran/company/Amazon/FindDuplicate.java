package com.simran.company.Amazon;

public class FindDuplicate {
    /*
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     * There is only one repeated number in nums, return this repeated number.
     * 
     */
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
    }

    // Brute force 
    // Sorting
    // Hashing

    // Optimal
    // Slow and Fast Pointer

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do { 
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
