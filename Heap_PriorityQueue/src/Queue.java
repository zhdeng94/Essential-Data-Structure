/**
 * This is an interface that defines the abstract data type of the queue.
 *
 * @author Zihao Deng
 * @since 2020-04-30
 * @param <E>
 */

public interface Queue<E> {

    /* Put element e into the queue */
    void enqueue(E e);

    /* Retrieve and remove the front of the queue. Throw an exception if
    *  queue is empty */
    E dequeue();

    /* Retrieve but not remove the front of the queue. Return null if queue
    *  is empty */
    E getFront();

    /* Return the size of the queue */
    int getSize();

    /* Return true if the queue is empty */
    boolean isEmpty();
}
