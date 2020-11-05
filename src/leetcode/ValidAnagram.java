package leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 
 * https://www.youtube.com/watch?v=oHwDqfz1LGw
 * 
 * @author fabiano
 *
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        // different sizes, no way to be anagrams
        if (s.length() != t.length())
            return false;
        
        // store all letters of alphanet
        int[] counts = new int[26];
        
        // let's add letters of first string to counts and then remove from second string. result should be 0
        for (char c : s.toCharArray()){
            counts[c-'a']++;
        }
        for (char c : t.toCharArray()){
            counts[c-'a']--;
        }
        
//        for (int i = 0; i < s.length(); i++) {
//            counts[s.charAt(i) - 'a']++;
//            counts[t.charAt(i) - 'a']--;
//        }
        
        // checking if any position of array is not 0 (s has more or less letter ? than t)
        for (int i : counts){
            if (i != 0)
                return false;
        }
        return true;
    }
}
