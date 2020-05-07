import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 1000000;
        Random random = new Random();

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeapify(array, false);
        System.out.println("Do not use heapify: " + time1 + " seconds");
        double time2 = testHeapify(array, true);
        System.out.println("Use heapify: " + time2 + " seconds");

    }

    private static double testHeapify(Integer[] arr, boolean useHeapify) {
        long time1 = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (useHeapify) {
            maxHeap = new MaxHeap<>(arr);
        } else {
            maxHeap = new MaxHeap<>();
            for (int i : arr) {
                maxHeap.add(i);
            }
        }
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = maxHeap.removeMax();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                System.out.println("Heap test fail!");
                break;
            }
        }
        System.out.println("Heap test succeed!");

        long time2 = System.nanoTime();
        return (time2 - time1) / 1000000000.0;
    }
}
