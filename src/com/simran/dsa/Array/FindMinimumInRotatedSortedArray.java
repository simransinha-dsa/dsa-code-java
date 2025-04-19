/**
 *
 * @author simransinha
 */

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinimumInRotatedSortedArrayBruteForceOptimal(new int[] {4,5,6,7,1,2}));
    }

    public static int findMinimumInRotatedSortedArrayBruteForce(int[] nums) {
        /**
         * this is not giving TLE but not right approach
         */
        Arrays.sort(nums);
        return nums[0];
    }

    public static int findMinimumInRotatedSortedArrayBruteForceOptimal(int[] nums) {
        /**
         * Minimum value will have greater number on both the side
         * We can use binary search
         */
        int start = 0;
        int end = nums.length - 1;
        if(nums.length == 1) return nums[0];
        if(nums[start] < nums[end]) return nums[start];
        while(start <= end) {
            int mid = start + (end - start) / 2; // Integer overflow
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            if(nums[prev] > nums[mid] && nums[mid] < nums[next]) return nums[mid];
            if(nums[end] < nums[mid]) start = mid + 1;
            else {
                end = mid; 
            }
        }
        return -1;
    }

    public static int findIndexOfMinimumInRotatedSortedArrayBruteForceOptimal(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        if(nums.length == 1) return 0;
        if(nums[start] < nums[end]) return start;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            if(nums[prev] > nums[mid] && nums[next] > nums[mid]) return mid;
            if(nums[end] < nums[mid]) start = mid + 1;
            else end = mid;
        }
        return -1;
    }
    
}
