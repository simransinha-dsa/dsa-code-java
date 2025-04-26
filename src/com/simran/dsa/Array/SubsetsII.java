import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
    public static void main(String[] args) {
        subsetsWithDup(new int[] {4 ,4 ,4 , 1 ,4});
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to have duplicates together
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> subsets = new HashSet<>();
        getAllSubsets(nums , 0 , new ArrayList<>() , subsets);

        for(List<Integer> list: subsets) {
            result.add(list);
        }

        return result;
    }

    public static void getAllSubsets(int[] nums , int index , List<Integer> subset , Set<List<Integer>> allUniqueSubsets) {
        allUniqueSubsets.add(new ArrayList<>(subset));
        for(int i = index ; i < nums.length ;i++) {
            subset.add(nums[i]);
            getAllSubsets(nums , i+1 , subset , allUniqueSubsets);
            subset.remove(subset.size() - 1);
        }
    }
}
