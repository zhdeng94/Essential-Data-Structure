/**
 * Implementation of an ArrayDeque using resizable array.
 *
 * @author Zihao Deng
 * @since 2020-05-13
 * @param <E> type parameter
 */

public class ArrayDeque<E> implements Deque<E> {

    private E[] data;
    private int head, tail, size;

    /* Constructor: create an array deque with desired capacity */
    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    /* Default constructor */
    public ArrayDeque() {
        this(9);
    }

    /* Add an element e to the front of the array deque */
    @Override
    public void addFirst(E e) {
        head = left(1, head);
        data[head] = e;
        size++;

        if (isFull()) { resize(getCapacity() * 2); }
    }

    /* Add an element e to the end of the array deque */
    @Override
    public void addLast(E e) {
        data[tail] = e;
        tail = right(1, tail);
        size++;

        if (isFull()) { resize(getCapacity() * 2); }
    }

    /* Remove and return the element at the front of the array deque */
    @Override
    public E removeFirst() {
        if (isEmpty()) { return null; }

        E toReturn = data[head];
        data[head] = null;
        head = right(1, head);
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return toReturn;
    }

    /* Remove and return the element at the end of the array deque */
    @Override
    public E removeLast() {
        if (isEmpty()) { return null; }

        tail = left(1, tail);
        E toReturn = data[tail];
        data[tail] = null;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return toReturn;
    }

    /* Return the element at the front of the array deque */
    @Override
    public E getFirst() {
        return get(0);
    }

    /* Return the element at the end of the array deque */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    /* Return the element at the index position of the array deque */
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return data[right(index, head)];
    }

    /* Set the element at the front of the array deque to e */
    public void setFirst(E e) {
        set(0, e);
    }

    /* Set the element at the end of the array deque to e */
    public void setLast(E e) {
        set(size - 1, e);
    }

    /* Set the element at the index position of the array deque to e */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            return;
        }
        data[right(index, head)] = e;
    }

    /* return the size of the array deque */
    @Override
    public int getSize() {
        return size;
    }

    /* return true if the array deque is empty */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* return the capacity of the array deque at this moment */
    public int getCapacity() {
        return data.length - 1;
    }

    /* resize the array into the desired capacity */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[head];
            head = right(1, head);
        }
        head = 0;
        tail = size;
        data = newData;
    }

    /* return true if the deque is full */
    private boolean isFull() {
        return right(1, tail) == head;
    }

    /* move the index k to the right by n */
    private int right(int n, int k) {
        return (n + k) % data.length;
    }

    /* move the index k to the left by n */
    private int left(int n, int k) {
        return (k - n) < 0 ? k - n + data.length : k - n;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array Deque of size %d and capacity %d\n", size, getCapacity()));
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                str.append(data[right(i, head)]);
                break;
            }
            str.append(data[right(i, head)] + "-");
        }
        return str.toString();
    }
}
