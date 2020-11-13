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
        reverseStringIt(s);
    }
    
    private void reverseStringIt(char[] s) {
        int i = 0;
        int j = s.length-1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
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
