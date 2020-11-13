package leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/submissions/
 * 
 * @author fabiano
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex < endIndex) {
            while (startIndex < endIndex && !Character.isLetterOrDigit(s.charAt(startIndex))) {
                startIndex++;
            }
            while (startIndex < endIndex && !Character.isLetterOrDigit(s.charAt(endIndex))) {
                endIndex--;
            }

            if (Character.toLowerCase(s.charAt(startIndex)) != Character.toLowerCase(s.charAt(endIndex))) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
