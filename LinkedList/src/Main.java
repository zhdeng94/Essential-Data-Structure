public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            list1.addLast(i);
            if (i % 3 == 0) {
                list1.removeLast();
            }
            System.out.println(list1);
        }

        System.out.println(list1.remove(2));
    }
}
