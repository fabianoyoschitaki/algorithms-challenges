/**
 * Implementation of Linked List following HackerRank:
 * 
 * https://www.youtube.com/watch?v=njTh_OwMljA&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=5
 * 
 * 
 * @author fabiano
 *
 */
public class MainHackerRankLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


class Node1 {
	int data;
	Node1 next;
	
	public Node1(int data){
		this.data = data;
	}
}

class LinkedList {
	Node1 head;
	
	/**
	 * Deletes the node which contain data
	 * 
	 * @param data
	 */
	public void deleteWithValue(int data) {
		if (head == null) return;
		
		// special case: what if the head has the data?
		if (head.data == data) {
			head = head.next;
			return; 
		}
		
		// testing the following nodes after head...
		Node1 current =  head;
		while (current.next != null) {
			// if next node has the value we're searching for, then replace next with next.next
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	/**
	 * Appends new node in the beginning of the linked list
	 * @param data
	 */
	public void prepend(int data) {
		Node1 newHead = new Node1(data);
		newHead.next = head;
		head = newHead;
	}
	
	/**
	 * Appends to the end of the linked list
	 * 
	 * @param data
	 */
	public void append(int data) {
		if (head == null) {
			head = new Node1(data);
			return;
		}
		
		Node1 current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node1(data);
	}
}