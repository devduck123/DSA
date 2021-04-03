import java.util.*;

/*
    PROBLEM: 
    Given an array of integers, find the unique value - 
    the value that does NOT repeat.
*/

public class singleNum {
    public static void main (String[] args) {
        int[] nums = {5, 4, 5, 3, 4, 3, 6}; // answer: 6

        System.out.println("Unique value: " + getSingleNum(nums)); // Errichto's doesn't seem to work as it should..
        System.out.println("Unique value: " + getSingleNumB(nums));
        System.out.println("Unique value: " + getSingleNumC(nums));
    }

    // optimal solution? (wtf Errichto, utilizes bitwise XOR to store total parity of bits we xored)
    static int getSingleNum(int[] arr) {
        int x = 0;;
        for (int num : arr) {
            x ^= num;   // ^ copies each num bit to x  .. note: | binary OR & binary AND
        }
        return x;
    }

    // iterative solution 
    static int getSingleNumB(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!isDuplicate(arr[i], arr)) {
                return arr[i];
            }
        }
        return -1; // no unique values
    }

    static boolean isDuplicate(int num, int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // DS HashMap solution 
    static int getSingleNumC(int[] arr) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numMap.put(arr[i], count(arr[i], arr));
        }
        // found this "iterating of Map" from geeksforgeeks
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // no unique values
    }

    static int count(int num, int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                counter++;
            }
        }
        return counter;
    }
}
