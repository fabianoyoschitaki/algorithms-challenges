package leetcode;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2973/
 * 
 * @author fabiano
 *
 */
public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // create set to store banned words
        Set<String> bannedSet = new HashSet<>();
        for (String bannedStr : banned) {
            bannedSet.add(bannedStr.toLowerCase());
        }
        
        // create map word vs repetitions
        Map<String, Integer> mapWords = new HashMap<>();
        
        // keep track of the most repeated word and its number of repetitions
        String mostCommonRepeatedWord = null;
        int maxRepetitions = 0;
        
        // split the paragraph into word tokens
        String[] tokens = paragraph.split("[ +\\!\\?\\'\\,\\;\\.]");
        for (String token : tokens) {
            String word = token.toLowerCase();
            if (!token.equals("") && !bannedSet.contains(word)) {
                int repetitions = 1;
                if (mapWords.containsKey(word)) {
                    repetitions = mapWords.get(word) + 1; 
                }
                mapWords.put(word, repetitions);
                if (repetitions > maxRepetitions) {
                    maxRepetitions = repetitions;
                    mostCommonRepeatedWord = word;
                }
            }
        } 
        return mostCommonRepeatedWord;
    }
    
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }
}
