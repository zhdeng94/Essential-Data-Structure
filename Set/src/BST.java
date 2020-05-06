/**
 * This is my implementation of a binary search tree, which supports generics.
 *
 * @author Zihao Deng
 * @since 2020-05-03
 * @param <E> type parameter
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {

    /* Definition of a tree node */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    /* Default constructor */
    public BST() {
        root = null;
        size = 0;
    }

    /* Return the size of the BST */
    public int getSize() {
        return size;
    }

    /* Return true if BST is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Add element e into the BST using recursion */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left =  add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /* Return true if BST contains element e using recursion */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /* BST preorder traversal using recursion */
    public void preOrder() {
        System.out.println("Preorder traversal recursive");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /* BST preorder traversal non recursive version */
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        System.out.println("Preorder traversal not recursive");
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    /* BST inorder traversal using recursion */
    public void inOrder() {
        System.out.println("Inorder traversal recursive");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node + " ");
        inOrder(node.right);
    }

    /* BST postorder traversal using recursion */
    public void postOrder() {
        System.out.println("Postorder traversal recursive");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + " ");
    }

    /* BST level order traversal */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        System.out.println("Level order traversal");
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            System.out.print(node + " ");

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        System.out.println();
    }

    /* Return the minimum value of the BST */
    public E minimum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty. No minimum!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /* Return the maximum value of the BST */
    public E maximum() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty. No maximum!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /* Remove the minimum value node of the BST */
    public void removeMin() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty. Cannot remove!");
        }
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /* Remove the maximum value node of the BST */
    public void removeMax() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty. Cannot remove!");
        }
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /* Remove the element e from BST */
    public void remove(E e) {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty. Cannot remove!");
        }
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }

        // e is either larger or smaller than current node value
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }

        // e is equal to current node value
        if (node.left == null && node.right == null) {
            size--;
            return null;
        } else if (node.left != null && node.right == null) {
            size--;
            return node.left;
        } else if (node.left == null && node.right != null) {
            size--;
            return node.right;
        }

        // left subtree and right subtree are not empty

        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        return successor;
    }

}
