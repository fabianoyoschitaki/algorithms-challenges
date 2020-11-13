package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 * 
 * @author fabiano
 *
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> mapChars = new HashMap<>();
        for (char c : s.toCharArray()){
            mapChars.put(c, mapChars.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++){
            if (mapChars.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
