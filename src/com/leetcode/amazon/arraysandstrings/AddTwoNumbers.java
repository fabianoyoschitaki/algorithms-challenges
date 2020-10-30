package com.leetcode.amazon.arraysandstrings;

/**
 * https://leetcode.com/problems/add-two-numbers/submissions/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        boolean hasCarryOver = false;
        while (l1 != null || l2 != null){
            int sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if (current != null){
                current.next = new ListNode();
                current = current.next;
            } else {
                current = new ListNode();
            }
            int total = sum + (hasCarryOver ? 1 : 0);
            current.val = total % 10;
            hasCarryOver = total >= 10 ? true : false;
            if (head == null){
                head = current;
            }
        }
        if (hasCarryOver){
            current.next = new ListNode(1);
        }
        return head;
    }
}
