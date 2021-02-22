package leetcode;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 * 
 * @author fabiano
 *
 */
public class ShortestWordDistance {

	/**
	 * Time complexity: O(N⋅M) where N is the number of words in
	 * the input list, and M is the total length of two input words.
	 * 
	 * Space complexity: O(1), since no additional space is allocated.
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestDistance(String[] words, String word1, String word2) {
		int posWord1 = -1;
		int posWord2 = -1;
		int minDistance = words.length;
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i])) {
				posWord1 = i;
			} else if (word2.equals(words[i])) {
				posWord2 = i;
			}
			if (posWord1 != -1 && posWord2 != -1) {
				minDistance = Math.min(minDistance, Math.abs(posWord1 - posWord2));
			}
		}
		return minDistance;
	}
}
