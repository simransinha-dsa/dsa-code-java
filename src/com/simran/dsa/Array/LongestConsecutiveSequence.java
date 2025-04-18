

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
     * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
     * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
     */
    
    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequenceOptimalII(new int[] {0,3,2,5,4,6,1,1}));
    }

    public static int longestConsecutiveSequenceBruteForce(int[] nums) {
        Set<Integer> set = new HashSet<>(); // O(n2)
        int max = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int num: nums) {
            int streak = 0;
            int curr = num;
            while(set.contains(curr)) {
                streak++;
                curr++;
            }
            max = Math.max(streak, max);
        }

        return max;
    }

    public static int longestConsecutiveSequenceOptimalI(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxLength = Integer.MIN_VALUE;
        int length = 1;

        int prev = nums[0];
        for(int i = 1; i < nums.length ; i++) {
            if(prev == nums[i]) continue;

            if(nums[i] == (prev + 1)) {
                length++;
            } else {
                
                length =1;
            }
            prev = nums[i];
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int longestConsecutiveSequenceOptimalII(int[] nums) {
            // Remove duplicate - use HashSet
            if(nums.length == 0) return 0;

            Set<Integer> set = new HashSet<>();

            for(int i = 0 ; i < nums.length ; i++) {
                set.add(nums[i]);
            }
            int maxLength = 1;

            for(Integer num : set) {
                int prev = num - 1;
                if(!set.contains(prev)) {
                    int length  = 1;
                    int next = num + 1;
                    while(set.contains(next)) {
                        length++;
                        next++;
                    }
                    maxLength = Math.max(maxLength, length);
                }
            }
            return maxLength;
        }
}
