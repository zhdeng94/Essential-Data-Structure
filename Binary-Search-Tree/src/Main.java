public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        int[] arr = {8, 5, 13, 1, 6, 10, 15, 4, 9, 12, 14, 16};

        for (int i : arr) {
            bst.add(i);
        }

        bst.preOrder();
        bst.preOrderNR();
        bst.inOrder();
        bst.postOrder();
        bst.levelOrder();
        System.out.println();

        bst.remove(13);
        bst.preOrderNR();
        System.out.println(bst.getSize());

        bst.removeMax();
        bst.preOrderNR();
        System.out.println(bst.getSize());

        bst.removeMin();
        bst.preOrderNR();
        System.out.println(bst.getSize());
    }
}
