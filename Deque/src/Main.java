public class Main {

    public static void main(String[] args) {

        Deque<Integer> d1 = new CircularLinkedList<>();

        for (int i = 0; i < 10; i++) {
            d1.addLast(i);
            if (i > 0 && i % 3 == 0) {
                d1.removeFirst();
            }
            System.out.println(d1);
        }

        System.out.println();

        Deque<Integer> d2 = new ArrayDeque<>(4);

        for (int i = 0; i < 10; i++) {
            d2.addLast(i);
            if (i > 0 && i % 3 == 0) {
                d2.removeFirst();
            }
            System.out.println(d2);
        }

        for (int i = 0; i < 4; i++) {
            d2.removeLast();
        }
        System.out.println(d2);
    }
}
