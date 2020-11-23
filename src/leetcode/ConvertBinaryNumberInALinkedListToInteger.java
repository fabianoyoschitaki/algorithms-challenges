package leetcode;

/**
 * 
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 
 * @author fabiano
 *
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    /**
     * Time complexity: O(N).
     * 
     * Space complexity: O(1).
     * 
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        int value = 0;
        while (head != null) {
            value = value * 2 | head.val;
            head = head.next;
        }
        return value;
    }
    
    public static int getDecimalValueWithBitManipulation(ListNode head) {
        int value = 0;
        while (head != null) {
            value = value << 1 | head.val;
            head = head.next;
        }
        return value;
    }

    public static void main(String[] args) {
        // 1 -> 1 -> 0 -> 1 -> null
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(0, new ListNode(1, null)))));
        int decimalValue = getDecimalValue(head);
        int decimalValueBitManipulation = getDecimalValueWithBitManipulation(head);
        System.out.println(decimalValue);
        System.out.println(decimalValueBitManipulation);
        
//        System.out.println(4 << 2 | 0 | 1);
        System.out.println(31 | 63);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(~10) + " - " + ~10);
        System.out.println(Integer.toBinaryString(~1) + " - " + ~1);
    }
}
