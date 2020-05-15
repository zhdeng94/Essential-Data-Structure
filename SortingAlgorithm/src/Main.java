import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // initialize data
        int testSize1 = 10;
        Integer[] arr = new Integer[testSize1];
        Random rand = new Random();
        for (int i = 0; i < testSize1; i++) {
            arr[i] = rand.nextInt(100);
        }

        // test correctness of bubble sort
        test(new BubbleSort<>(arr));

        // test correctness of insertion sort
        test(new SelectionSort<>(arr));

    }

    private static void test(Sort sortAlgo) {
        System.out.println("Before: Is array sorted? " + sortAlgo.isSorted());
        sortAlgo.sort();
        sortAlgo.print();
        System.out.println("After: Is array sorted? " + sortAlgo.isSorted());
        System.out.println();
    }
}
