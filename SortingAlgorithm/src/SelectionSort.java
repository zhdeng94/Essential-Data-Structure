/**
 * This is my implementation of a selection sort algorithm. The class supports
 * generics.
 *
 * @author Zihao Deng
 * @since 2020-05-14
 * @param <E> type parameter
 */

public class SelectionSort<E extends Comparable<E>> implements Sort {

    E[] data;

    public SelectionSort(E[] arr) {

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

        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i;

            // find the smallest one from unsorted portion
            for (int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[smallest]) < 0) {
                    smallest = j;
                }
            }

            // put the smallest one to the end of the sorted portion
            E temp = data[i];
            data[i] = data[smallest];
            data[smallest] = temp;
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

        System.out.println("Selection sort:");
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
