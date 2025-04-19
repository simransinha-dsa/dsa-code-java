/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simransinha
 */
public class BookAllocation {
    /*
     * Given an array books[] where books[i] represents the number of pages in the i-th book, 
     * and an integer m representing the number of students:
     * Objective: Allocate the books to m students such that:
     * Each student gets contiguous books.
     * Each book is allocated to exactly one student.
     * You need to minimize the maximum number of pages assigned to any student.
     * Return the minimized maximum number of pages assigned to a student.​
     */

     public static void main(String[] args) {
        System.out.println(bookAllocation(new int[] {12 , 34 , 67 , 90}, 2));
     }

     public static int bookAllocation(int[] nums , int k) {
        int maxPageValue = nums[0];
        int sum = nums[0];
        int minPages = -1;

        for(int i = 1 ; i < nums.length ; i++) {
            maxPageValue = Math.max(maxPageValue , nums[i]);
            sum += nums[i];
        }

        int start = maxPageValue; // because this is the minimum of max pages , one student can read
        int end = sum;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(isValid(nums , mid , k)) {
                minPages = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minPages;
     }

     public static boolean isValid(int[] nums , int maxPages , int k) {
        int student = 1;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if(sum > maxPages) {
                student++;
                sum = nums[i];
            }
            if(student > k) return false;
        }
        return true;
     }
}
