/**
 *
 * @author simransinha
 */

public class ContainerWithMostWater {

    /*
     * You are given an integer array height of length n. 
     * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     */

    public static void main(String[] args) {
        System.out.println(maxAreaBruteForce(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxAreaOptimal(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    // Brute Force
    // O(n2)

    public static int maxAreaBruteForce(int[] height) {
        // Time limit exceeded
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0 ; i < height.length -1 ; i++) {
            for(int j = i + 1; j < height.length ; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Optimal
    // O(n)

    public static int maxAreaOptimal(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(start <= end) {
            int width = end - start;
            int area = Math.min(height[start], height[end]) * width;
            maxArea = Math.max(maxArea, area);
            if(height[start] < height[end]) start++;
            else end--;
        }
        return maxArea;
    }
    
}
