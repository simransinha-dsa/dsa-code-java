/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.company.Microsoft;

import java.util.Arrays;

/**
 *
 * @author simransinha
 */
public class MergeTwoSortedArray {

    // Question Link - https://leetcode.com/problems/merge-sorted-array/description/

    public static void main(String[] args) {
        int[] nums1 = new int[] {4 , 5 , 6 , 0 , 0 , 0};
        int[] nums2 = new int[] {1 , 2 , 3};

        merge(nums1 , 3 , nums2 , 3);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = nums1.length - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i];
                i--;
            } else {
                nums1[index--] = nums2[j];
                j--;
            }
        }
        while(j >= 0) {
            nums1[index--] = nums2[j--];
        }

        // this code is not needed as we are doing in place for nums1 , so if i is remaining , 
        // it would be at right place
        // while(i >= 0) {
        //     nums1[index++] = nums1[i--];
        // }
    }

}
