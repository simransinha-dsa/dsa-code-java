/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;

/**
 *
 * @author simransinha
 */
public class NextPermutation {
    /*
     * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
     * For example, for arr = [1,2,3], the following are all the permutations of arr: 
     * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
     * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. 
     * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, 
     * then the next permutation of that array is the permutation that follows it in the sorted container.
     * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
     * Given an array of integers nums, find the next permutation of nums.
     * The replacement must be in place and use only constant extra memory.
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1 ,2 , 3 ,6 , 5 , 4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        // find the pivot which nums[i] < nums[i+1] starting from last
        // find the next larger number from pivot from the right
        // swap them
        // reverse the array afte pivot
        // e.g [1 , 2 , 3 , 6 , 5 ,4]
        // starting from right , pivot is 3 , because it is the element whose element on the right is greater
        // which is the right most greater number than 3 , it is 4 , so swap them [1 , 2 , 4 , 6 , 5 , 3]
        // now we know that 1 , 2 , 4 are in right place , 6 , 5, 3 needs to be the smallest number in the combination which is 3 , 5 , 6
        // so lets reverse them
        // so finally we will have [1 ,2 , 4 , 3 , 5 , 6] = ans

        int n = nums.length;
        int pivot = -1;

        for(int j = n-1 ; j > 0 ; j--) {
            if(nums[j-1] < nums[j]) {
                pivot = j-1;
                break;
            }
        }
        if(pivot == -1) { // which means the input array is the last combination of that numbers , so simply reverse or sort
            reverse(nums , 0);
            return;
        }

        // find the next larger element than pivot

        for(int i = n-1 ; i >= 0 ; i--) {
            if(nums[i] > nums[pivot]) {
                // swap these two
                swap(nums, pivot, i);
                break;
            }
        }
        // to form smallest combination after pivot 
        reverse(nums, pivot+1);
    }

    public static void reverse(int[] nums , int start) {
        int end = nums.length - 1;
        while(start <= end) {
            swap(nums, start , end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
