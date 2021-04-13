package NOTES;

public class BinarySearch {
    public static void main(String[] args) {
        // goal: find index of number 7 when sorted
        int[] nums = {1, 5, 7, 2, 3, 5, 4, 2, 5, 6, 1, 3, 4}; // should return index of 12, it's last
        int num = 7;

        // step 1: sort the array
        sort(nums);
        
        // step 2: implement Binary Search
        System.out.println("Index for " + num + " is: " + binarySearch(nums, num));
        
    }

    static int binarySearch(int[] arr, int target) {
        int mid, low, high;
        low = 0;
        high = arr.length-1;

        while (high >= low) {
            // mid = (high+low) / 2;
            mid = low + (high-low) / 2; // optimal 
            if (arr[mid] < target) {
                low = mid+1;
            }
            else if (arr[mid] > target) {
                high = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    static void sort(int[] arr) {
        // selection sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
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
