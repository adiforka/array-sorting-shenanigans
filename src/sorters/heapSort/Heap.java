package sorters.heapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap<E extends Comparable<E>> {

    private final List<E> list = new ArrayList<>();

    public Heap() {
    }

    public Heap(E[] objects) {
        list.addAll(Arrays.asList(objects));
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (list.get(currentIndex)
                    .compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else break; // the tree is a heap now (no child greater than parent)

            currentIndex = parentIndex;
        }
    }

    public E remove() {

        //always removing the root (largest element) from a heap, so when you start replacing elements in your
        //original, unsorted array, it'll be sorted. I guess if you want to sort in reverse, start adding elements
        //removed from the heap to the end of the array
        if (list.size() == 0) {
            return null;
        }

        //get element to remove (root)
        E removedElement = list.get(0);
        //replace old root with last element
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        //make the new root our current index
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size())
                break;
            //we want to swap the root with the larger of its children as long as its smaller than that child, and then
            //keep swapping down up the heap as long as the parent is smaller than the larger child, so we need to
            //compare the children first

            //going to say the left child is max, and then check if right child > left child, reassign to max as needed
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex)
                        .compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            //if element at current index < element at max index, swap
            if (list.get(currentIndex)
                    .compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            //else the tree is already a heap
            else break;
        }
        return removedElement;
    }

    public int getSize() {
        return list.size();
    }
}
