
public class MainRemoveDuplicatesLinkedList {

	public static void main(String args[]) {
		LinkedListNode head = null;
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		while (T-- > 0) {
//			int ele = sc.nextInt();
//			head = insert(head, ele);
//		}
		head = insert(head, 1);
		head = insert(head, 2);
		head = insert(head, 2);
		head = insert(head, 3);
		head = insert(head, 4);
		head = insert(head, 4);
		head = insert(head, 4);
		head = insert(head, 4);
		head = insert(head, 5);
		head = insert(head, 6);
		head = insert(head, 7);
		head = insert(head, 7);
		System.out.println("Before:");
		display(head);
		head = removeDuplicates(head);
		System.out.println("\n\nAfter:");
		display(head);
	}

	private static LinkedListNode removeDuplicates(LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode prev = null;
		while (current != null){
			if (prev != null && prev.data == current.data){
				prev.next = current.next;
				current = current.next;
				continue;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}

	public static void display(LinkedListNode head) {
		LinkedListNode start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}
	
	public static LinkedListNode insert(LinkedListNode head, int data) {
		LinkedListNode p = new LinkedListNode(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			LinkedListNode start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}
}

class LinkedListNode{
	int data;
	LinkedListNode next;
	LinkedListNode(int d){
        data=d;
        next=null;
    }
	
}
