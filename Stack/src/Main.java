public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();

        System.out.println("Stack is Empty: " + stack.isEmpty());

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        for (int i = 0; i < 4; i++) {
            stack.pop();
        }

        System.out.println(stack);

        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("After peek");
        System.out.println(stack);
    }
}
