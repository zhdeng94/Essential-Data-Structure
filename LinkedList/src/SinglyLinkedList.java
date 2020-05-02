/**
 * This is my implementation of a singly linked list, i.e. the node only points
 * to its next. The linked list supports generic data type.
 *
 * @author Zihao Deng
 * @since 2020-05-02
 * @param <E> generic data type
 */

public class SinglyLinkedList<E> {

    /* Node class: building block of a linked list */
    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    /* Constructor of a linked list */
    public SinglyLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /* Return the size of the linked list*/
    public int getSize() {
        return size;
    }

    /* Return true if linked list is empty and false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Add an element e into the index position of a linked list */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index must be between 0 and size!");
        }

        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /* Add an element to the head of the linked list */
    public void addFirst(E e) {
        add(e, 0);
    }

    /* Add an element e to the end of the linked list */
    public void addLast(E e) {
        add(e, size);
    }

    /* Remove and return the element at the index position */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index must be between 0 and size!");
        }
        if (isEmpty()) {
            throw new IllegalArgumentException("Linked list is empty. Cannot remove!");
        }

        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;

        prev.next = cur.next;
        cur.next = null;
        size--;

        return cur.e;
    }

    /* Remove and return the head of the linked list */
    public E removeFirst() {
        return remove(0);
    }

    /* Remove and return the end of the linked list */
    public E removeLast() {
        return remove(size - 1);
    }

    /* Return true if the element e is in the linked list and false otherwise */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /* Return the element at the index position. Throw an exception if the index
    *  is out of bound */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index must be between 0 and size!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /* Set the element at the index position to e */
    public boolean set(int index, E e) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Linked list: ");
        Node cur = dummyHead.next;
        while (cur != null) {
            str.append(cur);
            str.append("->");
            cur = cur.next;
        }
        str.append("null");
        return str.toString();
    }
}
