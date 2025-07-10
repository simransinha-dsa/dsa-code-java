package com.simran.company.Google;

import java.util.PriorityQueue;

public class KthLargestNumber {
    public static void main(String[] args) {
        findKthLargestNumber(new int[] {3,2,1,5,6,4}, 2);
    }

    public static int findKthLargestNumber(int[] nums , int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length ; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
