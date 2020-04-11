package sorters.selection_sorters;

import java.util.Arrays;

public class SelectionSorter {
    public static void main(String[] args) {

        double[] doubles = {4.5, -3.5, 13.3, 4.4, 1, 8.51, 42.89, 2.3, 0.1, 0, -0.1};
        System.out.println("Unsorted" + Arrays.toString(doubles));
        selectionSort(doubles);
        System.out.println("After insertion sort applied: " + Arrays.toString(doubles));
    }

    private static void selectionSort(double[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            double currentMin = list[i];
            int cmIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < currentMin) {
                    currentMin = list[j];
                    cmIndex = j;
                }
            }

            //if we have a new index for smallest element, swap the new and old smallest elements
            //otherwise the original candidate for min in this iteration of outer for loop (the old)
            // is still the smallest
            if (currentMin != i) {
                list[cmIndex] = list [i];
                list[i] = currentMin;
            }
        }

    }
}
