import java.util.*;

public class AltQuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 4, 1, 9, 5, 3));
        System.out.println("Unsorted: " + list);
        System.out.println("Sorted: " + quicksort(list));
    }

    public static ArrayList<Integer> quicksort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        ArrayList<Integer> lessThanPivot = new ArrayList<Integer>();
        ArrayList<Integer> greaterThanPivot = new ArrayList<Integer>();
        int pivot = list.get(0);
        int length = list.size();
        for (int i = 1; i < length; i++) {
            int currentValue = list.get(i);
            if (currentValue <= pivot) {
                lessThanPivot.add(currentValue);
            } 
            else {
                greaterThanPivot.add(currentValue);
            }
        }
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        sortedList.addAll(quicksort(lessThanPivot));
        sortedList.add(pivot);
        sortedList.addAll(quicksort(greaterThanPivot));
        return sortedList;
    }
}
