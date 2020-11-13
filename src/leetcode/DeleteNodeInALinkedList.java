package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
 * 
 * Time and space complexity are both O(1).
 *  
 * @author fabiano
 *
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
