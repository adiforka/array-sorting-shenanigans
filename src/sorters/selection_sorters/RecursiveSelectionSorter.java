package sorters.selection_sorters;

import java.util.Arrays;

public class RecursiveSelectionSorter {
    public static void main(String[] args) {

        int[] ints = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        System.out.println(Arrays.toString(ints));
        recSelectionSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void recSelectionSort(int[] ints) {
        recSelectionSort(ints, 0, ints.length - 1);
    }

    private static void recSelectionSort(int[] ints, int low, int high) {

        if (low < high) {
            int currentMin = ints[low];
            int minIndex = low;

            for (int k = low + 1; k < ints.length; k++) {
                if (ints[k] < currentMin) {
                    currentMin = ints[k];
                    minIndex = k;
                }
            }

            if (minIndex != low) {
                ints[minIndex] = ints[low];
                ints[low] = currentMin;
            }
            recSelectionSort(ints, low + 1, high);
        }
    }
}
