import java.util.Set;
import java.util.HashSet;
public class ContainsDuplicate {
    public static void main (String[] args) {
        int[] nums = {3, 5, 4, 1, 4, 7, 9}; // should return true
        System.out.println(containsDuplicate(nums));
    }

    // HashSet solution
    static boolean containsDuplicate(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : arr) {
            if (!numSet.add(i)) { // if set did not add num from arr, duplicate=true
                return true;
            }
        }
        return false;
    }
}
