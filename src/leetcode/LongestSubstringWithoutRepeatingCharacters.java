package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author fabiano
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int answer = 0;
        Set<Character> uniqueChars = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (!uniqueChars.contains(s.charAt(end))) {
                uniqueChars.add(s.charAt(end));
                end++;
                answer = Math.max(answer, uniqueChars.size());
            } else {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
        }
        return answer;
    }
}
