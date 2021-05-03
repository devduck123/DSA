public class MergeSort {
    public static void main(String[] args) {
        int [] numbers = {10, 2, 78, 4, 45, 32, 7, 11};
        int left = 0;
        int right = numbers.length-1;

        System.out.print("Unsorted: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();

        mergeSort(numbers, left, right);

        System.out.print("Sorted: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void merge(int[] numbers, int left, int mid, int right) {
        int mergedSize = right - left + 1;    // size of merged partition
        int mergedNumbers[] = new int[mergedSize]; // temporary array for merged numbers
        int mergeIndex = 0; // index to insert merged number
        int leftIndex = left; // index of elements in left partition (left-mid inclusive)
        int rightIndex = mid+1; // index of elements in right partition (mid-right exclusive)

        // add smallest element from left OR right partition to mergedNumbers
        while (leftIndex <= mid && rightIndex <= right) {
            if (numbers[leftIndex] < numbers[rightIndex]) {
                mergedNumbers[mergeIndex] = numbers[leftIndex];
                ++leftIndex;
            }
            else {
                mergedNumbers[mergeIndex] = numbers[rightIndex];
                ++rightIndex;
            }
            ++mergeIndex;
        }

        // if left partition not empty, add remaining elements to mergedNumbers
        while (leftIndex <= mid) {
            mergedNumbers[mergeIndex] = numbers[leftIndex];
            ++leftIndex;
            ++mergeIndex;
        }

        // if right partition not empty, add remaining elements to mergedNumbers
        while (rightIndex <= right) {
            mergedNumbers[mergeIndex] = numbers[rightIndex];
            ++rightIndex;
            ++mergeIndex;
        }

        // copy mergeNumbers back to numbers
        for (mergeIndex = 0; mergeIndex < mergedSize; ++mergeIndex) {
            numbers[left+mergeIndex] = mergedNumbers[mergeIndex];
        }
    }

    public static void mergeSort(int[] numbers, int left, int right) {
        int mid;
        
        if (left < right) {
            mid = left + (right-left) / 2; // find midpoint in partition

            // recursively sort left and right partitions
            mergeSort(numbers, left, mid);
            mergeSort(numbers, mid+1, right);

            // merge left and right partitions in sorted order
            merge(numbers, left, mid, right);
        }
    }
}


/*
 * MergeSort Overview:
  - partition array into two halves
    - recursively partitions until list has 1 element => aka sorted
  - recursively sort each half
  - merge sorted halves into a sorted list
    - repeatedly select smallest element from left or right partition
    - add to a temporary list, copy to original list
  - O(NlogN) since list is divided in half till 1 elements left => the partitioning
*/