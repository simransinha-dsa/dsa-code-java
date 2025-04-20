import java.util.HashMap;
import java.util.Map;

public class SubArraySumToK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1 , 1 , 1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        // intuition here is to keep the complement sum in map 
        // to check if any sub array is giving me k sum
        Map<Integer , Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int count = 0;
        int current_sum = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            current_sum += nums[i];
            count += sums.getOrDefault(current_sum - k , 0);
            sums.put(current_sum , sums.getOrDefault(current_sum , 0) + 1);
        }
        return count;
    }

    public static int subarraySumBruteForce(int[] nums , int k) {
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            int sum = 0;
            for(int j = i ; j < nums.length ; j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}
