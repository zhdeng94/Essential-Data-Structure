/**
 * This is my implementation of a merge sort algorithm. The class supports
 * generics.
 *
 * @author Zihao Deng
 * @since 2020-05-15
 * @param <E> type parameter
 */

public class MergeSort<E extends Comparable<E>> implements Sort {

    E[] data;

    public MergeSort(E[] arr) {

        data = (E[]) new Comparable[arr.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
    }

    @Override
    public void sort() {

        if (data == null && data.length == 0) {
            throw new IllegalArgumentException("Fail! No data to sort!");
        }

        E[] temp = (E[]) new Comparable[data.length];
        mergeSort(data, 0, data.length - 1, temp);
    }

    private void mergeSort(E[] arr, int start, int end, E[] temp) {

        if (start >= end) { return; }

        mergeSort(arr, start, (start + end) / 2, temp);
        mergeSort(arr, (start + end) / 2 + 1, end, temp);

        merge(arr, start, end, temp);
    }

    private void merge(E[] arr, int start, int end, E[] temp) {

        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int tempIndex = start;

        while (leftIndex <= middle && rightIndex <= end) {
            if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            temp[tempIndex++] = arr[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = arr[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    @Override
    public void print() {

        if (data == null && data.length == 0) {
            throw new IllegalArgumentException("Fail! No data to print!");
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < data.length - 1; i++) {
            str.append(data[i] + " ");
        }
        str.append(data[data.length - 1]);

        System.out.println("Merge sort:");
        System.out.println(str.toString());
    }

    @Override
    public boolean isSorted() {

        if (data == null && data.length == 0) {
            throw new IllegalArgumentException("Fail! No data to sort!");
        }

        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
