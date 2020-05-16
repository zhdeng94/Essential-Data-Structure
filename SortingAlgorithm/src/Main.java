import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // initialize data
        int testSize1 = 20;
        Integer[] arr = new Integer[testSize1];
        Random rand = new Random();
        for (int i = 0; i < testSize1; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println("Test correctness\n");

        // test correctness of bubble sort
        test(new BubbleSort<>(arr));

        // test correctness of selection sort
        test(new SelectionSort<>(arr));

        // test correctness of insertion sort
        test(new InsertionSort<>(arr));

        // test correctness of merge sort
        test(new MergeSort<>(arr));

        // test correctness of quick sort
        test(new QuickSort<>(arr));


        // initialize data
        int testSize2 = 30000;
        Integer[] arr2 = new Integer[testSize2];
        for (int i = 0; i < testSize2; i++) {
            arr2[i] = rand.nextInt(30000);
        }

        System.out.println("Compare performance\n");

        System.out.println(String.format("Bubble sort: %f s", time(new BubbleSort<>(arr2))));
        System.out.println(String.format("Selection sort: %f s", time(new SelectionSort<>(arr2))));
        System.out.println(String.format("Insertion sort: %f s", time(new InsertionSort<>(arr2))));
        System.out.println(String.format("Merge sort: %f s", time(new MergeSort<>(arr2))));
        System.out.println(String.format("Quick sort: %f s", time(new QuickSort<>(arr2))));

    }

    private static void test(Sort sortAlgo) {
        System.out.println("Before: Is array sorted? " + sortAlgo.isSorted());
        sortAlgo.sort();
        sortAlgo.print();
        System.out.println("After: Is array sorted? " + sortAlgo.isSorted());
        System.out.println();
    }

    private static double time(Sort sortAlgo) {
        long t1 = System.nanoTime();
        sortAlgo.sort();
        long t2 = System.nanoTime();
        return (t2 - t1) / 1000000000.0;
    }
}
