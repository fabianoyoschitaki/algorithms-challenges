package leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Definition for singly-linked list. 
 *  
 *  public class ListNode { 
 *      int val; 
 *      ListNode next; 
 *      ListNode() {} 
 *      ListNode(int val) { 
 *          this.val = val; 
 *      } 
 *      ListNode(int val, ListNode next) { 
 *          this.val = val; 
 *          this.next = next; 
 *      } 
 *  }
 */
public class PalindromeLinkedList{
    
    /**
     * Approach 2: Recursive (Advanced)
     */
    private static ListNode frontPointer;
    
    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            System.out.println("currentNode is: " + currentNode.val);
            if (!recursivelyCheck(currentNode.next)) {
                System.out.println("!recursivelyCheck(currentNode.next) -> returning false");
                return false;
            }
            System.out.println(currentNode.val + " = " + frontPointer.val + " ?");
            if (currentNode.val != frontPointer.val) {
                System.out.println("currentNode.val != frontPointer.val -> returning false");
                return false;
            }
            frontPointer = frontPointer.next;
            if (frontPointer != null) {
                System.out.println("frontPointer is now: " + frontPointer.val);
            }
        } else {
            System.out.println("currentNode is null. Base case of recursion, returning true");
        }
        // recursion base case
        return true;
    }
    
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
    
}
