
public class MainHackerrankStack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.peek();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

class Stack {
	private static class Node {
		private int data;
		private Node prev;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int peek() {
		return top == null ? -1 : top.data;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		if (top != null) { // this is not necessary because if top is null, then node.next is null anyway
			node.prev = top;
		}
		top = node;
	}
	
	public int pop() {
		if (top != null) {
			int data = top.data;
			top = top.prev;
			return data;
		}
		return -1;
	}
}
