import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author simransinha
 */

public class PairSum {

    /*
     * Given an array of integers nums and an integer target, 
     * return the indices of the two numbers such that they add up to the target.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSum(new int[] {2, 11, 7, 15}, 9)));
        System.out.println(Arrays.toString(pairSumOptimal(new int[] {2, 11, 7, 15}, 9)));
        System.out.println(Arrays.toString(pairSumOptimalI(new int[] {2, 7, 11, 15}, 9)));
    }

    // Brute Force
    // O(n2)

    public static int[] pairSum(int[] nums , int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i , j};
                }
            }
        }
        return new int[2];
    }


    // Optimal
    // O(n)

    public static int[] pairSumOptimal(int[] nums , int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[] {i , map.get(diff)};
            }
            map.put(nums[i] , i);
        }
        return new int[2];
    }

    // Optimal
    // O(n)
    // If question says already sorted , 
    // the use two pointers


    public static int[] pairSumOptimalI(int[] nums , int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {left , right};
            } else if(nums[left] + nums[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        return new int[2];
    }
}
