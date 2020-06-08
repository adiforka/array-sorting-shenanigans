package sorters.heapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        Integer[] numbers = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        heapSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    public static <E extends Comparable<E>> void heapSort(E[] arr) {

        Heap<E> heap = new Heap<>();

        //sorting array by adding all its elements to the heap
        for (E e : arr) {
            heap.add(e);
        }

        //then removing from heap and adding back to array
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.remove();
        }
    }
}
