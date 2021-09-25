import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class ContainsDuplicate {
    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 2}; // true
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate2(nums));
    }

    // HashSet Approach (more time-optimal)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // HashSet inherently does not accept duplicates
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // brute-force Approach (more space-optimal)
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums); // O(n log n)

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
