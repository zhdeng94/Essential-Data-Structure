/**
 * This is my implementation of a queue using array as the underlying data
 * structure. The array is dynamic and circular.
 *
 * @author Zihao Deng
 * @since 2020-04-30
 * @param <E>
 */

public class ArrayQueue<E> implements Queue<E> {

    private LoopArray<E> array;

    public ArrayQueue(int capacity) {
        array = new LoopArray<>(capacity);
    }

    public ArrayQueue() {
        this(8);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        if (array.isEmpty()) {
            throw new IllegalCallerException("Queue is Empty! Cannot dequeue!");
        }
        return array.removeFront();
    }

    @Override
    public E getFront() {
        return array.getFront();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), array.getCapacity()));
        str.append("Front ");
        for (int i = 0; i < getSize(); i++) {
            str.append(array.get(i));
            str.append(" ");
        }
        str.append("Tail");
        return str.toString();
    }

    private class LoopArray<E> {

        private E[] data;
        private int size;
        private int head;
        private int tail;

        public LoopArray(int capacity) {
            data = (E[]) new Object[capacity + 1];
            size = 0;
            head = 0;
            tail = 0;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public int getSize() {
            return size;
        }

        public int getCapacity() {
            return data.length - 1;
        }

        public E getFront() {
            if (size == 0) {
                return null;
            }
            return data[head];
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Index out of bound!");
            }
            return data[(head + index) % data.length];
        }

        public void addLast(E e) {
            if (addOne(tail) == head) {
                resize(getCapacity() * 2);
            }

            data[tail] = e;
            tail = addOne(tail);
            size++;
        }

        public E removeFront() {
            E element = data[head];
            data[head] = null;
            head = addOne(head);
            size--;

            if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
                resize(getCapacity() / 2);
            }
            return element;
        }

        private void resize(int capacity) {
            E[] newData = (E[]) new Object[capacity + 1];
            for (int i = 0; i < size; i++) {
                newData[i] = data[(i + head) % data.length];
            }
            data = newData;
            head = 0;
            tail = size;
        }

        private int addOne(int index) {
            return (index + 1) % data.length;
        }
    }
}
