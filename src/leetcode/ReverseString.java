package leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
 * 
 * @author fabiano
 *
 */
public class ReverseString {
    public void reverseString(char[] s) {
        reverseStringRec(s, 0, s.length-1);
    }
    
    public void reverseStringRec(char[] s, int start, int end){
        if (start >= end)
            return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseStringRec(s, start+1, end-1);
    }
}
