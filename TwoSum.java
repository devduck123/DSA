import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static void main (String[] args) {
        int[] nums = {2, 6, 9, 7, 1, 7};
        int target = 10; // indices 2 and 4 -> values 9 and 1

        printArray(findTwoIndices(nums, target));
        printArray(optimalFindTwoIndices(nums, target));
    }

    /* 
    
    given an array of integers:
    return the two indices that 
    add up to a target sum
    NOTE: CANNOT use same element twice
    
    */


    // brute-force approach O(n^2)
    static int[] findTwoIndices(int[] nums, int target) {
        int[] indices = {-1, -1}; // assume indices not found

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // CANNOT use same element twice
                if (i == j) {
                    break; // go to next value to repeat comparisons
                }

                // if index1 + index2 == target...
                if (nums[i] + nums[j] == target) {
                    indices[0] = i; 
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    // HashMap approach O(n)
    static int[] optimalFindTwoIndices(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // find dynamic difference
            int diff = target - nums[i];

            // we'll be mapping each element to its index

            // but first, have we put the difference in our map?
            if (map.containsKey(diff)) {
                // good thing we have the index mapped to it!
                // return the mapped index and the current index
                // since the key is the current element's diff 
                return new int[]{map.get(diff), i};
            }

            // (K, V) = (value, value_index)
            // continue to map each element to its index
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }

    static void printArray(int[] nums) {
        System.out.print("Indices: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}