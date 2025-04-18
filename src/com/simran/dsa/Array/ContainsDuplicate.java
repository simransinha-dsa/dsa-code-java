

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Question - 217
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        // System.out.println(containsDuplicateOptimalII(new int[] {1,1,1,3,3,4,3,2,4,2}));
        System.out.println(containsDuplicateOptimalI(new int[] {1 ,2 , 3}));
    }

    public static boolean containsDuplicateBruteForce(int[] nums) {
        // Time limit exceeded
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1 ; j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateOptimal(int[] nums) {
        // O(nlogn)
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicateOptimalI(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
