import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 	Input: "abcabcbb"
 * 	Output: 3 
 * 	Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * 	Input: "bbbbb"
 * 	Output: 1
 * 	Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 	Input: "pwwkew"
 * 	Output: 3
 * 	Explanation: The answer is "wke", with the length of 3. 
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author fabiano
 *
 */
public class MainFindLongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int lastChar = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                lastChar = Math.max(lastChar, map.get(s.charAt(i)));
            }
            answer = Math.max(answer, (i - lastChar + 1));
            map.put(s.charAt(i), i+1);
        }
        return answer;
    }
}
