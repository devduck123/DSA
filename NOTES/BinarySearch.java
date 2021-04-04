package NOTES;

public class BinarySearch {
    public static void main(String[] args) {
        // goal: find index of number 7 when sorted
        int[] nums = {1, 5, 7, 2, 3, 5, 4, 2, 5, 6, 1, 3, 4}; // should return index of 12, it's last
        int num = 7;

        // step 1: sort the array
        sort(nums);
        
        // step 2: implement Binary Search
        int start = 0;
        int end = nums.length-1;
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Index for " + num + " is: " + binarySearch(nums, num, start, end));
        
    }

    static int binarySearch(int[] arr, int target, int left, int right) {
        // recursive binary search
        if (right >= left) {
            int mid = (left + right)/2; 

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr, target, left, mid-1);
            }
            else {
                return binarySearch(arr, target, mid+1, right);
            }
        }
        return -1; // error - not found
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
