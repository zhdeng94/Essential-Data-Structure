/**
 * This is my own implementation of an array data structure that supports
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

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

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


}
