public class BinarySearch {
    public static void main (String[] args) {
        int[] nums = {1, 2, 3, 5, 7};
        int target = 3; // should return 2

        System.out.println(binarySearch(nums, target));

        int low = 0;
        int high = nums.length-1;
        System.out.println(recursiveBinarySearch(nums, target, low, high));

    }

    // written by Tabnine
    static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length-1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                low = mid + 1;
             }
             else if (array[mid] > target) {
                 high = mid - 1;
            }
        }
        return -1;
    }

    static int recursiveBinarySearch(int[] array, int target, int low, int high) {
        // base case
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
            
        if (array[mid] == target) {
            return mid;
        }
        else if (array[mid] < target) {
            return recursiveBinarySearch(array, target, mid+1, high);
        }
        else if (array[mid] > target) {
            return recursiveBinarySearch(array, target, low, mid-1);
        }
        
        return -1;
    }
}
