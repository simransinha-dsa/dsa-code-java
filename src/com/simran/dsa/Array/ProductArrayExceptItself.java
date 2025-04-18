import java.util.Arrays;

/**
 *
 * @author simransinha
 */

public class ProductArrayExceptItself {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfBruteForce(new int[] {1 , 2 , 3 , 4})));
        System.out.println(Arrays.toString(productExceptSelfOptimalI(new int[] {1 , 2 , 3 , 4})));
        System.out.println(Arrays.toString(productExceptSelfOptimalII(new int[] {1 , 2 , 3 , 4})));
    }

    // Brute Force
    // O(n2)

    public static int[] productExceptSelfBruteForce(int[] nums) {
        // Time limit Exceeded on leetcode
        int[] product = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int value = 1;
            for(int j = 0 ; j < nums.length; j++) {
                if(i != j)
                    value *= nums[j];
            }
            product[i] = value;
        }
        return product;
    }

    // Optimal I
    // Space O(n)
    // Time O(n)

    public static int[] productExceptSelfOptimalI(int[] nums) {
        // nums = [1, 2 , 3 ,4];
        // left = [1, 1 , 2 , 6];
        // right = [24 ,12, 4, 1];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] product = new int[nums.length];

        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i-1] * leftProduct[i-1];
        }
        for(int j = nums.length - 2; j >= 0; j--) {
            rightProduct[j] = nums[j+1] * rightProduct[j+1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }

        return product;
    }

    // Optimal II
    // One array which is result , so space is O(n)
    // Time O(n)

    public static int[] productExceptSelfOptimalII(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;

        for(int i = 1 ; i < nums.length ; i++) { // left array directly in product
            product[i] = product[i-1] * nums[i-1];
        }

        int right = 1;

        for(int j = nums.length - 1; j >= 0 ; j--) {
            product[j] *= right;
            right *= nums[j];
        }
        return product;
    }
}
