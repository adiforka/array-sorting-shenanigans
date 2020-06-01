package sorters.bubble_sort;

import java.util.Arrays;

public class BubbleSorter {
    public static void main(String[] args) {

        BubbleSorter bb = new BubbleSorter();
        int[] ints = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        System.out.println("Unsorted array: " + Arrays.toString(ints));
        bb.bubbleSort(ints);
        System.out.println("Array after sorting: " + Arrays.toString(ints));
    }

    //bubbling largest elements to the right end of the array
    public void bubbleSort(int[] values) {

        boolean needNextPass = true;
        for (int i = 0; i < values.length && needNextPass; i++) {
            //switch to false, and if there are any swaps, which means the array's not yet sorted
            //switch back to true while swapping
            needNextPass = false;

            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
