public class SelectionSort {
    public static void main (String[] args) {
        int[] nums = {4, 1, 6, 5, 2, 9, 8, 7, 8, 9, 3, -1};

        SelectionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }


    }

    static void SelectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < list[i]) {
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
}
