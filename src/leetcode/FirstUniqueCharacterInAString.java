package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 * 
 * Should not the space complexity be O(1)? The algorithm is iterating over a
 * constant(26) number of bins as keys for hashmap. Alternatively one can use an
 * integer array count[26] for keeping the count of char counts in the word.
 * 
 * @author fabiano
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> mapChars = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapChars.put(c, mapChars.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (mapChars.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public int firstUniqCharUsingArray(String s) {
        int[] count = new int[26];
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        // find the index
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }
}
