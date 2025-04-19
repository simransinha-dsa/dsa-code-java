package com.simran.company.Google;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simransinha
 */
public class MajorityElement {

    /*
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     */

     public static void main(String[] args) {
        System.out.println(majorityElementBruteForce(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
        System.out.println(majorityElementOptimalI(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
        System.out.println(majorityElementOptimalII(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
        System.out.println(majorityElementOptimalIII(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
     }

     // Brute Force
     // O(n2)

     public static int majorityElementBruteForce(int[] nums) {
        int maxCount = nums.length / 2;

        for(int num: nums) {
            int count = 0;
            for(int i = 0 ; i < nums.length ; i++) {
                if(num == nums[i]) {
                    count++;
                    if(count > maxCount) return num;
                }
            }
        }
        return -1;
     }

     // Optimal I
     // O(nlogn)
     // Constant space

     public static int majorityElementOptimalI(int[] nums) {
        int maxCount = nums.length / 2;
        int count = 1;

        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] == nums[i+1]) {
                count++;
                if(count > maxCount) return nums[i];
            } else {
                count = 1;
            }
        }
        return -1;
     }

     // Optimal II
     // Space O(n)
     // Time O(n)

     public static int majorityElementOptimalII(int[] nums) {
        int maxCount = nums.length / 2;

        Map<Integer , Integer> fre = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
            if(fre.get(nums[i]) > maxCount) return nums[i];
        }

        return -1;
     }

     // Optimal III
     // Moore's Voting Algorithm
     // Frequency of element is like a power
     // The highest frequency element will always have the highest power
     // frequency if subtracted can never be zero if majority elements exists
     // Intuition here is majority element will not let frequecy to be zero

     public static int majorityElementOptimalIII(int[] nums) {
        int frequency = 0;
        int element = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            if(frequency == 0) {
                element = nums[i];
            }
            if(element == nums[i]) {
                frequency++;
            } else {
                frequency--;
            }
        }
        // this can be changed to check if fre is greater than n /2 , if question is
        // saying, answer can or cannot exists.
        return element;
     }
   
}
