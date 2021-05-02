public class FirstAndLastIndex {
    public static void main (String[] args) {
        // goal: find the first and last index of a value x in a sorted array
        int x = 8;
        int[] nums = {2, 3, 3, 6, 6, 8, 8, 8, 8}; // should return 5 and 8

        // assign indices from solution
        int[] indices = new int[1];
        indices = searchRange(nums, x);
        
        // test solution
        System.out.print("Indices: ");
        for (int i : indices) {
            System.out.print(i + " ");
        }


    }

    // binary search (Errichto)
    static int first_pos(int[] nums, int x) {
        int n = nums.length;
        int first = n;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] >= x) {
                first = mid;
                high = mid-1;
            }
            else { // nums[mid] < x
                low = mid+1;
            }
        }
        return first;
    }

    static int[] searchRange(int[] nums, int x) {
        int first = first_pos(nums, x);
        int last = first_pos(nums, x+1) - 1;
        if (first <= last) {
            int [] indices = {first, last};
            return indices;
        }
        int[] indices = {-1 ,-1}; // failed to find indices
        return indices;
    }
}
