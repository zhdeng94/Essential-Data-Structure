/**
 * This is the interface that defines the abstract data type of Set
 * @author Zihao Deng
 * @since 2020-05-06
 * @param <E> type parameter
 */

public interface Set<E> {

    /* Add an element e into set */
    void add(E e);

    /* Remove the element e from the set */
    void remove(E e);

    /* Return true if the element e is in the set */
    boolean contains(E e);

    /* Return the size of the set */
    int getSize();

    /* Return true if the set is empty */
    boolean isEmpty();
}
