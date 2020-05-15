/**
 * This is an interface that defines the relevant methods for sorting.
 * Different sorting algorithm class will implement this interface.
 *
 * @author Zihao Deng
 * @since 2020-05-14
 */

public interface Sort {

    /* Sort the data from smallest to largest */
    void sort();

    /* print the sorted data */
    void print();

    /* return true if the data is sorted */
    boolean isSorted();
}
