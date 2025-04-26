package com.simran.company.Amazon;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    // Find pairs in an array which satisy below conditions
    // i < j and arr[i] > arr[j]
    public static void main(String[] args) {
        System.out.println(mergeSort(new int[] {6 , 3 , 5 , 2 ,7} , 0 , 4));
    }

    public static int countInversionsBruteForce(int[] nums) {
        // nested loop
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = i+1 ; j < nums.length ; j++) {
                if(nums[i] > nums[j]) count++;
            }
        }
        return count;
    }

    // use of merge sort

    public static int mergeSort(int[] nums , int start , int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;

            int leftCount = mergeSort(nums, start, mid);
            int right = mergeSort(nums, mid+1, end);

            int currentInversionCount = merge(nums , mid , start , end);

            return leftCount + right + currentInversionCount;
        }

        return 0;

    }

    public static int merge(int[] nums , int mid, int start , int end) {
        List<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        int inversionCount = 0;

        while(i <= mid && j <= end) {
            if(nums[i] <= nums[j]) {
               temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
                inversionCount = (mid - i + 1);
            }
        }

        while(i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while(j <= end) {
            temp.add(nums[j]);
            j++;
        }

        for(int idx = 0 ; idx < temp.size(); idx++) {
            nums[idx + start] = temp.get(idx);
        }

        return inversionCount;
    }
}
