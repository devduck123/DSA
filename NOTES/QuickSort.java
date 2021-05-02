public class QuickSort {
    public static void main (String[] args) {
        int[] numbers = {10, 2, 78, 4, 45, 32, 7, 11};
        int low = 0;
        int high = numbers.length-1;

        System.out.print("Unsorted: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();

        quicksort(numbers, low, high); 

        System.out.print("Sorted: ");
        for (int i: numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int partition(int[] numbers, int l, int h) {
        int low = l;
        int high = h;
        int mid;
        int pivot;
        int temp;
        boolean sorted = false; 

        mid = l + (h-l) / 2; // optimal midpoint formula
        pivot = numbers[mid]; // assign pivot to midpoint's value

        while (!sorted) {
            // increment low while low value < pivot value
            while (numbers[low] < pivot) {
                ++low;
            }

            // decrement high while high value > pivot
            while (numbers[high] > pivot) {
                --high;
            }

            // if 0 or 1 elements left, all numbers are partitioned
            if (low >= high) {
                sorted = true;
            }
            else {
                // swap low value and high value, update low and high
                temp = numbers[low];
                numbers[low] = numbers[high];
                numbers[high] = temp;

                ++low;
                --high;
            }
        }

        return high;
    }

    public static void quicksort(int[] numbers, int l, int h) {
        int lastLow;

        // base case: if 0 or 1 elements to sort, partition already sorted
        if (l >= h) {
            return;
        }

        // partition elements within array
        // assign j to location of last element in low partition
        lastLow = partition(numbers, l, h);

        // recursively sort low and high partitions
        quicksort(numbers, l, lastLow);
        quicksort(numbers, lastLow+1, h);
    }
}


/*
    QuickSort Overview
    - repeatedly partitions input into low and high
        - chooses a pivot to divide into low and high (middle)
    - recursively sort each part until a partition has 1 or 0 elements 
    - => sorted
*/