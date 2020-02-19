import java.util.Stack;

public class MainImplementStackWith2Queues {

	public static void main(String[] args) {
		QueueUsingStacks<Integer> myQueue = new QueueUsingStacks<>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		myQueue.enqueue(6);
		myQueue.enqueue(7);
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
	}

}

class QueueUsingStacks<T> {
	private Stack<T> stackNewestOnTop = new Stack<>();
	private Stack<T> stackOldestOnTop = new Stack<>();
	
	public void enqueue(T value) {
		stackNewestOnTop.push(value);
	}
	
	public T peek() {
		if (stackOldestOnTop.isEmpty()) {
			while (!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}
		return stackOldestOnTop.peek();
	}
	
	public T dequeue() {
		if (stackOldestOnTop.isEmpty()) {
			while (!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}
		return stackOldestOnTop.pop();
	}
}
