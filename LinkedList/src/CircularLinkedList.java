/**
 * My implementation of a circular doubly-linked list that supports generics
 *
 * @author Zihao Deng
 * @since 2020-05-13
 * @param <E> type parameter
 */

public class CircularLinkedList<E> {

    /* Node class: building block of this linked list */
    private class Node {

        public E e;
        public Node prev, next;

        public Node(E e, Node prev, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node sentinel;
    private int size;

    /* Constructor */
    public CircularLinkedList() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Return true if the linked list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Return the size of the linked list */
    public int getSize() {
        return size;
    }

    /* Add an element e to the head of the linked list */
    public void addFirst(E e) {
        Node newNode = new Node(e, sentinel, sentinel.next);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    /* Add an element e to the tail of the linked list */
    public void addLast(E e) {
        Node newNode = new Node(e, sentinel.prev, sentinel);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    /* Add an element e to the index position. Throw an exception if index is
    *  out of bound */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail! Index if out of bound!");
        }

        Node insertPos = sentinel;
        for (int i = 0; i < index; i++) {
            insertPos = insertPos.next;
        }

        Node newNode = new Node(e, insertPos, insertPos.next);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    /* Remove and return the first element in the linked list.
    *  Return null if the list is empty. */
    public E removeFirst() {
        if (size == 0) { return null; }

        Node toRemove = sentinel.next;
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        size--;
        return toRemove.e;
    }

    /* Remove and return the last element in the linked list.
     * Return null if the list is empty. */
    public E removeLast() {
        if (size == 0) { return null; }

        Node toRemove = sentinel.prev;
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        size--;
        return toRemove.e;
    }

    /* Remove and return the element at the index position in the linked list.
     * Return null if the list is empty or if index is out of bound. */
    public E remove(int index) {
        if (index < 0 || index >= size) { return null; }

        Node toRemove = sentinel.next;
        for (int i = 0; i < index; i++) {
            toRemove = toRemove.next;
        }
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        size--;
        return toRemove.e;
    }

    /* Return the element at the index position in the linked list.
     * Return null if the list is empty or if the index is out of bound. */
    public E get(int index) {
        if (index < 0 || index >= size) { return null; }

        Node toReturn = sentinel.next;
        for (int i = 0; i < index; i++) {
            toReturn = toReturn.next;
        }
        return toReturn.e;
    }

    /* Set the element at the index position to e. Do nothing if the linked
    *  list is empty or if the index is out of bound. */
    public void set(E e, int index) {
        if (index < 0 || index >= size) { return; }

        Node toSet = sentinel.next;
        for (int i = 0; i < index; i++) {
            toSet = toSet.next;
        }
        toSet.e = e;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Circular linked list of size %d\n", size));
        Node cur = sentinel.next;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                str.append(cur);
                break;
            }
            str.append(cur + "<->");
            cur = cur.next;
        }
        return str.toString();
    }
}
