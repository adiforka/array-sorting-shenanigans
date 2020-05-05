package sorters.quick_sorters.obj_quicksorter;

public class ObjectQuickSorter<E extends Comparable<E>> {

    public void quicksort(E[] array) {
        quicksort(array, 0, array.length - 1);

    }

    private void quicksort(E[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private int partition(E[] array, int first, int last) {
        E pivot = array[first];
        int low = first + 1;
        int high = last;

        while (low < high) {
            while (low <= high && array[low].compareTo(pivot) <= 0) {
                low++;
            }

            while (low <= high && array[high].compareTo(pivot) >= 0) {
                high--;
            }

            if (low < high) {
                E temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }

        while (high > first && array[high].compareTo(pivot) >= 0) {
            high--;
        }

        if (array[high].compareTo(pivot) < 0) {
            array[first] = array[high];
            array[high] = pivot;
            return high;
        }
        else return first;
    }
}
