package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/solution/
 * 
 * Complexity Analysis
 *
 *   Time Complexity: O(log⁡(x)). There are roughly log⁡10(x) digits in x.
 *   Space Complexity: O(1).
 * 
 * @author fabiano
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            int lastDigit = x % 10;
            
            if (result > Integer.MAX_VALUE/10 || 
                (result == Integer.MAX_VALUE/10 && lastDigit > Integer.MAX_VALUE % 10)){
                return 0;
            } else if (result < Integer.MIN_VALUE/10 || 
                (result == Integer.MIN_VALUE/10 && lastDigit < Integer.MIN_VALUE % 10)){
                return 0;
            } 
            
            result = lastDigit + result * 10;
            x /= 10;            
        }      
        return result;
    }
}
