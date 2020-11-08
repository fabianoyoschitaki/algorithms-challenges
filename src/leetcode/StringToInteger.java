package leetcode;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/
 * 
 * @author fabiano
 *
 */
public class StringToInteger {
    public static int myAtoi(String s) {
        int index = 0;
        // removing spaces
        while (index < s.length() && s.charAt(index) == ' ' ){
            index++;
        }
        
        // if there were only spaces, return 0
        if (index == s.length()){
            return 0;
        }
        
        boolean isPositive = true;
        // checking if has sign character
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            isPositive = s.charAt(index) == '+';
            index++;
        } 
        // or it's not a number
        else if (s.charAt(index) < '0' || s.charAt(index) > '9'){
            return 0;
        }
        
        int result = 0;
        // get current character, check while it's valid (number) and string has not ended
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            // checking if number will overflow either by being > than integer max value / 10 or if it's equals but current number exceeds max integer last number
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && s.charAt(index)-'0' > Integer.MAX_VALUE % 10)){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + s.charAt(index)-'0';    
            index++;
        }
        
        return isPositive ? result : -1 * result;
    }
    
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("     w"));
        System.out.println(myAtoi("   12   1"));
    }
}
