package sorters.quick_sorters.prim_quicksorter;

import java.util.Arrays;
import java.util.Random;

public class QuickSorterJoeJames {
    public static void main(String[] args) {

        QuickSorterJoeJames qs = new QuickSorterJoeJames();
        int[] numbers = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        System.out.println("Unsorted array: " + Arrays.toString(numbers));
        qs.quickSort(numbers);
        System.out.println("Array after sorting: " + Arrays.toString(numbers));
    }

    //sole public method
    public void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(int[] numbers, int low, int high) {
        if (low <= high) { //changed from if (low < high + 1)
            int partition = partition(numbers, low, high);
            quickSort(numbers, low, partition - 1);
            quickSort(numbers, partition + 1, high);
        }
    }

    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    private int partition(int[] numbers, int low, int high) {
        swap(numbers, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            //if element at index currently considered < pivot
            if (numbers[i] < numbers[low])
                //border will be incremented and its value changed as many times as
                //value of numbers[i] < pivot
                swap(numbers, i, border++);
        }

        //put pivot value in the right position (border - 1 becomes pivot index and we return that
        //as an axis for the next partitioning
        swap(numbers, low, border - 1);
        return border - 1;
    }
}
