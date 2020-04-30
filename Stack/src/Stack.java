/**
 * This is an interface that defines the abstract data type of the stack
 *
 * @author Zihao Deng
 * @since 2020-04-30
 * @param <E> generic type parameter
 */

public interface Stack<E> {

    /* put the element e to the top of the stack */
    void push(E e);

    /* remove the element at the top of the stack */
    E pop();

    /* retrieve the element at the top of the stack but not remove it */
    E peek();

    /* get the size of the stack */
    int getSize();

    /* return true if the stack is empty and false otherwise */
    boolean isEmpty();
}
