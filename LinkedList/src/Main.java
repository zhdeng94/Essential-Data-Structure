import java.util.Currency;

public class Main {

    public static void main(String[] args) {

        // test singly linked list
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list1.addLast(i);
            if (i % 3 == 0) {
                list1.removeLast();
            }
            System.out.println(list1);
        }

        System.out.println(list1.remove(2));

        System.out.println();

        // test circular linked list
        CircularLinkedList<Integer> list2 = new CircularLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list2.addLast(i);
            if (i % 3 == 0) {
                list2.removeFirst();
            }
            System.out.println(list2);
        }

        list2.add(100, 4);
        list2.remove(6);
        System.out.println(list2);
    }
}
