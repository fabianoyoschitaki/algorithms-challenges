
public class MainHackerrankQueue {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.peek();
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(5);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}

class Queue {
	private static class Node {
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head; // items are removed from the head
	private Node tail; // items are added to the tail
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int peek() {
		return head.data;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
		}
	}
	
	public int remove() {
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}
}
