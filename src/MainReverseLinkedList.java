public class MainReverseLinkedList {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
		printList(root);
		root = reverseList(root);
		printList(root);
	}
	
	public static void printList(Node node){
		StringBuffer sb = new StringBuffer();
		if (node != null){	
			sb.append(node.value);
			while (node.next != null){
				node = node.next;
				sb.append("->").append(node.value);
			}
		}
		System.out.println(sb.toString());
	}
	
	private static Node reverseList(Node node){
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
}

class Node {
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
	}
	
	public Node(int value, Node next){
		this.value = value;
		this.next = next;
	}
}
