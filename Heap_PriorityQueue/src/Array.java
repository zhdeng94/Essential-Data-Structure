/**
 * This is my implementation of an array data structure that supports
 * generic data type and it can dynamically maintain the size of the array.
 *
 * @author Zihao Deng
 * @param <E> generic data type
 * @since 2020-04-27
 */

public class Array<E> {

    private E[] data;
    private int size;

    /* Constructor: create an array of size @param:capacity */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /* Default constructor: create an array of size 8 */
    public Array() {
        this(8);
    }

    /* Constructor: create an resizable array using input array */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /* Add an element e into the array at the index position */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("Index should be between 0 and %d", size));
        }
        if (size == getCapacity()) {
            resize(2 * getCapacity());
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /* Add an element e into the head of the array */
    public void addFirst(E e) {
        add(e, 0);
    }

    /* Add an element e into the tail of the array */
    public void addLast(E e) {
        add(e, size);
    }

    /* Return true if the array contains element e */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /* Remove and return the element at the index position of the array */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("Index should be between 0 and %d", size - 1));
        }

        E element = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return element;
    }

    /* Remove and return the first element of the array */
    public E removeFirst() {
        return remove(0);
    }

    /* Remove and return the last element of the array */
    public E removeLast() {
        return remove(size - 1);
    }

    /* Remove the the first appearance of e in the array if the array contains e
    *  Return true if the removal is successful and false otherwise */
    public boolean removeElement(E e){
        int index = find(e);
        if(index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /* Return the index of the first element e in the array, and return -1
    *  if the element is not found */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /* Return the element at the index position of the array */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("Index should be between 0 and %d", size - 1));
        }
        return data[index];
    }

    /* Set the element at the index position of the array to e */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(String.format("Index should be between 0 and %d", size - 1));
        }
        data[index] = e;
    }

    /* Swap two element at index i and j */
    public void swap(int i, int j) {
        if (i < 0 || i >= data.length || j < 0 || j >= data.length) {
            throw new IllegalArgumentException("Index out of bound!");
        }
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    /* Get the number of elements the array */
    public int getSize() {
        return size;
    }

    /* Get the capacity of the array */
    public int getCapacity() {
        return data.length;
    }

    /* Return true if the array is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Resize the array into specified capacity */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array size: %d, Array capacity: %d\n", size, getCapacity()));
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            str.append(" ");
        }
        return str.toString();
    }


}
