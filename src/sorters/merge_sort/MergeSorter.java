package sorters.merge_sort;

import java.util.Arrays;

public class MergeSorter {
    public static void main(String[] args) {

        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        System.out.println("Unsorted" + Arrays.toString(list));
        mergeSort(list);
        System.out.println("After insertion sort applied: " + Arrays.toString(list));
    }

    private static void mergeSort(int[] list) {
        //if input array has length > 1, divide it into two halves...
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            //...and call mergesort on each half recursively
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            //...and call mergesort on each half recursively
            mergeSort(secondHalf);

            //merge the two halves into larger and larger arrays until you've used all the elements
            //in the partial lists (see merge impl)
            merge(firstHalf, secondHalf, list);
        }
    }

    private static void merge(int[] sourceList1, int[] sourceList2, int[] targetList) {
        int current1 = 0; //current index in subarray1
        int current2 = 0; //current index in subarray2
        int current3 = 0; //current index in the array into which the two partials are combined

        while (current1 < sourceList1.length && current2 < sourceList2.length) {
            //see target array's index is incremented always,
            // and the partial's only if its element' is added
            if (sourceList1[current1] < sourceList2[current2])
                targetList[current3++] = sourceList1[current1++];
            else
                targetList[current3++] = sourceList2[current2++];
        }

        //if elements remain in one or the other (but not both!) of the partial arrays which
        //have not been put in the target array, assign them all to the target array one after another
        while (current1 < sourceList1.length) {
            targetList[current3++] = sourceList1[current1++];
        }

        while (current2 < sourceList2.length) {
            targetList[current3++] = sourceList2[current2++];
        }
    }
}
