/**
 * This is my implementation of a insertion sort algorithm. The class supports
 * generics.
 *
 * @author Zihao Deng
 * @since 2020-05-15
 * @param <E> type parameter
 */

public class InsertionSort<E extends Comparable<E>> implements Sort {

    E[] data;

    public InsertionSort(E[] arr) {

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

        for (int i = 1; i < data.length; i++) {
            int prevIndex = i - 1;
            E toInsert = data[i];
            while (prevIndex >= 0 && data[prevIndex].compareTo(toInsert) > 0) {
                data[prevIndex + 1] = data[prevIndex];
                prevIndex--;
            }
            data[prevIndex + 1] = toInsert;
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

        System.out.println("Insertion sort:");
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
