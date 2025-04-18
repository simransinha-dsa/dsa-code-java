import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /*
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     */

     public static void main(String[] args) {
        System.out.println(majorityElementBruteForce(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
        System.out.println(majorityElementOptimal(new int[] {5 ,5 ,5 ,5 ,3 ,2 ,5}));
     }

     // Brute Force
     // Space O(n)
     // Time O(n)

     public static int majorityElementBruteForce(int[] nums) {
        int maxCount = nums.length / 2;

        Map<Integer , Integer> fre = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer , Integer> map: fre.entrySet()) {
            if(map.getValue() > maxCount) return map.getKey();
        }

        return -1;
     }

     // Optimal
     // O(n)
     // Constant space

     public static int majorityElementOptimal(int[] nums) {
        int maxCount = nums.length / 2;
        int count = 1;

        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] == nums[i+1]) {
                count++;
                if(count > maxCount) return nums[i];
            } else {
                count = 1;
            }
        }
        return -1;
     }
    
}
