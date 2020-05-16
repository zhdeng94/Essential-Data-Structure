/**
 * This is my implementation of a quick sort algorithm. The class supports
 * generics.
 *
 * @author Zihao Deng
 * @since 2020-05-15
 * @param <E> type parameter
 */

public class QuickSort<E extends Comparable<E>> implements Sort {

    E[] data;

    public QuickSort(E[] arr) {

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

        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(E[] arr, int start, int end) {

        if (start >= end) { return; }

        E pivot = arr[(start + end) / 2];

        int left = start;
        int right = end;

        while (left <= right) {

            while (left <= right && arr[left].compareTo(pivot) < 0) {
                left++;
            }

            while (left <= right && arr[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                E temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
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

        System.out.println("Quick sort:");
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
