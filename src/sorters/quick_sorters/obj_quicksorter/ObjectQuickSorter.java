package sorters.quick_sorters.obj_quicksorter;

public class ObjectQuickSorter<T extends Comparable<T>> {

    public void quicksort(T[] words) {
        quicksort(words, 0, words.length - 1);

    }

    private void quicksort(T[] words, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(words, low, high);
            quicksort(words, low, pivotIndex - 1);
            quicksort(words, pivotIndex + 1, high);
        }
    }

    private int partition(T[] words, int first, int last) {
        T pivot = words[first];
        int low = first + 1;
        int high = last;

        while (low < high) {
            while (low <= high && words[low].compareTo(pivot) <= 0) {
                low++;
            }

            while (low <= high && words[high].compareTo(pivot) >= 0) {
                high--;
            }

            if (low < high) {
                T temp = words[low];
                words[low] = words[high];
                words[high] = temp;
            }
        }

        while (high > first && words[high].compareTo(pivot) >= 0) {
            high--;
        }

        if (words[high].compareTo(pivot) < 0) {
            words[first] = words[high];
            words[high] = pivot;
            return high;
        }
        else return first;
    }
}
