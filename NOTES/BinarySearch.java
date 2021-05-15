public class BinarySearch {
    public static void main(String[] args) {
        // goal: find index of number 7 when sorted
        int[] nums = {1, 5, 7, 2, 3, 5, 4, 2, 5, 6, 1, 3, 4}; // should return index of 12, it's last
        int target = 7;

        // sort the array
        sort(nums);
        
        // implement Binary Search
        System.out.println("Index for " + target + " is: " + binarySearch(nums, target));
        System.out.println("Index for " + target + " is: " + recursiveBinarySearch(nums, target, 0, nums.length-1));
        
    }

    static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (numbers[mid] == target) {
                return mid; // target found
            }
            // too low, check high partition
            else if (numbers[mid] < target) {
                low = mid+1;
            }
            // too high, check low partition 
            else if (numbers[mid] > target) {
                high = mid-1;
            }
        }
        return -1; // target not found
    }

    static int recursiveBinarySearch(int[] numbers, int target, int low, int high) {
        // avoid overflow
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (numbers[mid] == target) {
            return mid; // target found
        }
        // too low, check high partition
        else if (numbers[mid] < target) {
            return recursiveBinarySearch(numbers, target, mid+1, high);
        }
        // too high, check low partition
        else if (numbers[mid] > target) {
            return recursiveBinarySearch(numbers, target, low, mid-1);
        }

        return -1; // target not found
    }

    static void sort(int[] arr) {
        // selection sort
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i+1; j < arr.length; ++j) {
                int temp;
                if (arr[j] < arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
