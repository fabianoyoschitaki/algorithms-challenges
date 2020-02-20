/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 
 * 
 * Explanation: 342 + 465 = 807.
 * 
 * @author fabiano
 */
public class MainAddTwoNumbersStoredInLinkedLists {
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(1);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);
//		l2.next.next.next = new ListNode(9);
		ListNode addTwoNumbers = addTwoNumbers(l1, l2);
		while (addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val + "->");
			addTwoNumbers = addTwoNumbers.next;
		}
	}
	
	/**
	 * Definition for singly-linked list. 
	 * 
	 * public class ListNode { 
	 * 		int val; 
	 * 		ListNode next; 
	 * 		ListNode(int x) { 
	 * 			val = x; 
	 * 		} 
	 * }
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode answer = null;
		ListNode current = null;
		while (l1 != null || l2 != null) {
			int sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (answer == null) {
				answer = new ListNode((sum + carry) % 10);
				current = answer;
			} else {
				ListNode temp = new ListNode((sum + carry) % 10);
				current.next = temp;
				current = current.next;
			}
			carry = (sum+carry)/10;
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
            current = current.next;
		}
		return answer;
	}
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}
}