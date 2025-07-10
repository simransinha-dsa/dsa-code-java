package com.simran.company.Google;

public class MaximumDistanceBetweenPairs {
    public static void main(String[] args) {
        int[] nums1 = new int[] {55,30,5,4,2};
        int[] nums2 = new int[] {100,20,10,10,5};

        int[] nums3 = new int[] {2 , 2 , 2};
        int[] nums4 = new int[] {10 , 10, 1};

        int[] nums5 = new int[] {30,29,19,5};
        int[] nums6 = new int[] {25,25,25,25,25};

        System.out.println(maxDistance(nums1, nums2));
        System.out.println(maxDistance(nums3, nums4));
        System.out.println(maxDistance(nums5, nums6));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        int maxDistance = Integer.MIN_VALUE;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                int dis = j - i;
                maxDistance = Math.max(maxDistance, dis);
                j++;
            } else {
                i++;
                if(i > j) {
                    j = i;
                }
            }
        }

        return maxDistance;
    }
}
