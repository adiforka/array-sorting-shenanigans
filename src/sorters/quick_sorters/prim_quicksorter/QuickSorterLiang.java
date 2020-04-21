package sorters.quick_sorters.prim_quicksorter;

import java.util.Arrays;
import java.util.stream.IntStream;

//attempt #4
public class QuickSorterLiang {
    public static void main(String[] args) {

        //getting an array of values from a seed
        int[] ints = IntStream
                .iterate(0, i -> i + 2)
                .limit(1000)
                .toArray();

        //randomize array elements
        shuffle(ints);
        System.out.println("Unsorted, randomized array: " + Arrays.toString(ints));
        quickSort(ints);
        System.out.println("Array after sorting: " + Arrays.toString(ints));
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        //get values < pivot on its left and > pivot on its right (until high == low or high < low)
        while (high > low) {
            //find the first element that's > pivot starting from the left (exits this loop)
            while (low <= high && list[low] <= pivot) {
                low++;
            }
            //find the first element that's <= pivot starting from the right (exits this loop)
            while (low <= high && list[high] > pivot) {
                high--;
            }
            //swap the values for the 2 located elements (check that high > low, because maybe
            //at this point the high and low meet and there's no point swapping
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        //looking for the first high value < pivot to put the pivot in the right place
        while (high > first && list[high] >= pivot) {
            high--;
        }

        //the array may look this way: pivot on the left and the rest sorted "around its value"
        //point is to locate the high value with which to swap it
        // 5, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9

        //if I actually found some value for high index that's < pivot, swap them...
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            //...and return the new pivot index
            return high;
            //otherwise, if high got all the way down to first(the index of pivot), return first
            //(this is unfortunate for performance, as you for the next iteration you get one
            //subarray that's almost empty, and one that's almost the size of the current one)
        } else return first;
    }

    //this just to randomized input array
    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}
