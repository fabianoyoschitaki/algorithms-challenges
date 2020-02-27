/**
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if
 * the list is empty.
 * 
 * One way you know there's a loop in the list is if you've seen somewhere that
 * you've been before. Another way is to imagine there are 2 cars driving around
 * the racetrack. If cars drive at different speeds, then you know, if there's a
 * loop, they will eventually collide, pass each other. So we can have 2
 * pointers moving through the list at different speeds: 1 moving 2 nodes every
 * time, the other moves 1 node. If there's no loop, they'll get to the end of
 * the linked list.
 * 
 * @author fabiano
 *
 */
public class MainHackerRankDetectCycleInLinkedList {
	
	public static void main(String[] args) {
		LLNode head = new LLNode(0);
		head.next = new LLNode(1);
		head.next.next = new LLNode(2);
		head.next.next.next = new LLNode(3);
		head.next.next.next.next = new LLNode(4);
		head.next.next.next.next.next = new LLNode(5);
		head.next.next.next.next.next.next = new LLNode(6);
		head.next.next.next.next.next.next.next = new LLNode(7);
		head.next.next.next.next.next.next.next.next = head;
		System.out.println(hasCycle(head));

	}

	static boolean hasCycle(LLNode head) {
		if (head == null) {
			return false;
		}
		LLNode fast = head.next;
		LLNode slow = head;
		
		// while none of them reached the end of the list
		while (fast != null && fast.next != null && slow != null) {
			System.out.println("\nSlow is: " + slow.data);
			System.out.println("Fast is: " + fast.data);
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
}

class LLNode {
	int data;
	LLNode next;

	public LLNode(int data) {
		this.data = data;
	}
}

