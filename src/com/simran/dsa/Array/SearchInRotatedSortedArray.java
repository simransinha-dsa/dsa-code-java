/**
 *
 * @author simransinha
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[] {1} , 0));
    }

    // public static int searchInRotatedSortedArray(int[] nums , int target) {
    //     for(int i = 0 ; i < nums.length ; i++) { // O(n)
    //         if(target == nums[i]) return i;
    //     }

    //     return -1;
    // }

    // public static int searchInRotatedSortedArrayOptimal(int[] nums , int target) {
    //     /*
    //      * Divide the array into two sorted arrays by finding the minimum element
    //      * 0 to minimum element index - 1 will be one sorted array
    //      * minimum element index to array.length will 2nd sorted array
    //      */
    //     int minimumIndex = FindMinimumInRotatedSortedArray.findIndexOfMinimumInRotatedSortedArrayBruteForceOptimal(nums);
    //     int indexFromLeft = binarySearch(nums, 0, minimumIndex - 1, target);
    //     int indexFromRight = binarySearch(nums, minimumIndex, nums.length - 1, target);
    //     if(indexFromLeft == -1 && indexFromRight == -1) return -1;
    //     if(indexFromLeft == -1) return indexFromRight;
    //     else return indexFromLeft;
    // }

    // public static int binarySearch(int[] nums , int start , int end , int target) {
    //     while(start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if(nums[mid] == target) return mid;
    //         if(nums[mid] > target) end = mid - 1;
    //         else {
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    public static int search(int[] nums, int target) {
        int minimumIndex = findMinimumIndex(nums);
        int leftIndex = binarySearch(nums , 0 , minimumIndex - 1 , target);
        int rightIndex = binarySearch(nums , minimumIndex , nums.length - 1 , target);

        if(leftIndex == -1 && rightIndex == -1) return -1;
        if(rightIndex == -1) return leftIndex;
        else return rightIndex;
    }

    public static int findMinimumIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;
            if(nums[prev] > nums[mid] && nums[next] > nums[mid]) {
                return mid;
            } else if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return -1;
    }

    public static int binarySearch(int[] nums , int start , int end , int target) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
    
}
