/**
 * This is the interface that defines the abstract data type of a double ended
 * queue (deque). The deque supports generics.
 *
 * @author Zihao Deng
 * @since 2020-05-13
 * @param <E> type parameter
 */

public interface Deque<E> {

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();

    E getFirst();

    E getLast();

    int getSize();

    boolean isEmpty();
}
