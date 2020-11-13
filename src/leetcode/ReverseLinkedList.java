package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
 * 
 * @author fabiano
 *
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
