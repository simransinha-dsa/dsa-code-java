/**
 *
 * @author simransinha
 */

public class SingleElementInSortedArray {
    
    public static void main(String[] args) {
        System.out.println(singleElementInSortedArrayBruteForce(new int[] {1 ,1 , 2 ,2 , 3 ,3 ,4 , 5 ,5}));
        System.out.println(singleElementInSortedArrayOptimal(new int[] {1 ,1 , 2 ,2 , 3 ,3 ,4 , 5 ,5}));
    }

    // Brute Force
    // O(n)
    public static int singleElementInSortedArrayBruteForce(int[] nums) {
        int count = 1;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] == nums[i+1]) {
                count++;
            } else {
                if(count != 2) {
                    return nums[i];
                }
                count = 1;
            }
        }
        return -1;
    }

    // Optimal I
    // O(logn)
    // Binary Search

    public static int singleElementInSortedArrayOptimal(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1) return nums[0];
        if(nums[low] != nums[low+1]) return nums[low];
        if(nums[high] != nums[high-1]) return nums[high];

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;

            if(nums[prev] != nums[mid] && nums[mid] != nums[next]) return nums[mid];
            // now if my mid is coming at the even index , 
            // and we know the original length of array is always going to be odd
            // so if mid is at even index, left and right arrays are even lengths array
            // if mid is at odd index , left and right arrays are odd lengths array
            // even length means , if my mid matches with mid -1, unique is present in left side
            // odd means , if my mid matches with mid - 1 , unique is present in right side

            if(mid % 2 == 0) {
                if(nums[mid - 1] == nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid - 1] == nums[mid]) {
                    low = mid +1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
