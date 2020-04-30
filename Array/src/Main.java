public class Main {

    public static void main(String[] args) {

        Array<Integer> arr1 = new Array<>(4);
        Array<String> arr2 = new Array<>();

        // test add related methods
        arr1.addLast(6);
        arr1.addFirst(5);
        arr1.add(9, 1);
        System.out.println(arr1);

        arr1.addLast(8);
        arr1.addFirst(3);
        System.out.println(arr1);

        // test remove related methods
        arr1.removeLast();
        arr1.remove(1);
        arr1.removeFirst();
        System.out.println(arr1);

        arr1.removeLast();
        System.out.println(arr1);

        for (int i = 1; i < 10; i++) {
            arr1.addLast(i);
        }

        // test contains method
        System.out.println("Array contains 5: " + arr1.contains(5));
        System.out.println("Array contains 11: " + arr1.contains(11));

        // test set method
        arr1.set(6, 20);
        System.out.println(arr1);

        // test array of type String
        arr2.addFirst("a");
        arr2.addLast("b");
        arr2.add("c", 1);
        System.out.println(arr2);

        arr2.addLast("d");
        arr2.addLast("h");
        arr2.add("j", 3);
        arr2.addFirst("q");
        arr2.addLast("1");
        arr2.addLast("y");
        System.out.println(arr2);
    }
}
