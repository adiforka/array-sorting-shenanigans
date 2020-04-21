package sorters.insertion_sort;

import java.util.Arrays;

public class InsertionSorter {
    public static void main(String[] args) {

        int[] list = {1, 9, 342, 9238, -223, 0, 12, 4, 6, 5, -4};
        System.out.println("Unsorted" + Arrays.toString(list));
        insertionSort(list);
        System.out.println("After insertion sort applied: " + Arrays.toString(list));
    }

    public static void insertionSort(int[] list) {

        //list[0] assumed to be already "sorted" (against itself)
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            //make room for insertion in the right spot
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            //insert new element -- //gotta do k + 1 because the last thing I did with
            // k was decrement it, maybe below 0
            list[k + 1] = currentElement;
        }
    }
}
