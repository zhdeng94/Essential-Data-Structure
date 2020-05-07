/**
 * My implementation of a binary max heap with resizable array as the underlying
 * data structure.
 *
 * @author Zihao Deng
 * @since 2020-05-07
 * @param <E> type parameter
 */

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(data.getSize() - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    /* Return the size of the heap */
    public int size() {
        return data.getSize();
    }

    /* Return true if the heap is Empty */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* Return the index of the parent node */
    private int parent(int k) {
        if (k == 0) {
            throw new IllegalArgumentException("Root node has no parent!");
        }
        return (k - 1) / 2;
    }

    /* Return the index of the left child node */
    private int leftChild(int k) {
        return k * 2 + 1;
    }

    /* Return the index of the right child node */
    private int rightChild(int k) {
        return k * 2 + 2;
    }

    /* Get the maximum element of the heap */
    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is empty! Cannot find max!");
        }
        return data.get(0);
    }

    /* Add an element e into the heap */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /* Sift up the element at index k */
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /* Remove and return the maximum element from the heap */
    public E removeMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Heap is empty. Cannot remove!");
        }
        E max = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    /* Sift up the element at index k */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            // data[j] is the larger one between left and right child
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E replace(E e) {
        E result = findMax();
        data.set(0, e);
        siftDown(0);
        return result;
    }
}
