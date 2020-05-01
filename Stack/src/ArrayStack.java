/**
 * This is my implementation of a stack using dynamic array as the underlying
 * data structure.
 *
 * @author Zihao Deng
 * @since 2020-04-30
 * @param <E> generic type parameter
 */

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
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
        str.append(String.format("Stack: size = %d\n", array.getSize()));
        for (int i = 0; i < array.getSize(); i++) {
            str.append(array.get(i));
            str.append(" ");
        }
        str.append("Top");
        return str.toString();
    }
}
