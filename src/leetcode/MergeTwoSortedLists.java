package leetcode;
/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author fabiano
 *
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(4);
		l1.next.next.next.next.next = new ListNode(10);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(5);

		ListNode result = mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(-1);
		ListNode temp = ans;
		while (l1 != null || l2 != null) {
			if (l1 != null && (l2 == null || l1.val < l2.val)) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		return ans.next;
	}
}
