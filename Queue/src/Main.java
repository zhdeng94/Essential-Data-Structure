public class Main {

    public static void main(String[] args) {
	    Queue<Integer> q = new ArrayQueue<>();

	    for (int i = 0; i < 10; i++) {
	        q.enqueue(i);
        }
	    System.out.println(q);

	    for (int i = 0; i < 4; i++) {
	        q.dequeue();
        }
        System.out.println(q);

	    for (int i = 0; i < 8; i++) {
	        q.enqueue(i + 10);
        }
        System.out.println(q);

		for (int i = 0; i < 10; i++) {
			q.dequeue();
		}
		System.out.println(q);
    }
}
