public class Main {

    public static void main(String[] args) {

        Array<Integer> arr1 = new Array<>(4);
        Array<String> arr2 = new Array<>();

        arr1.addLast(6);
        arr1.addFirst(5);
        arr1.add(9, 1);
        System.out.println(arr1);

        arr1.addLast(8);
        arr1.addFirst(3);
        System.out.println(arr1);

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
