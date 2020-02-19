import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 * 
 * 
 * Complexity Analysis
 * 
 * Time Complexity: O(N K log K), where N is the length of strs, and
 * K is the maximum length of a string in strs. The outer loop has complexity
 * O(N) as we iterate through each string. Then, we sort each string in O(K log K) time.
 * 
 * Space Complexity: O(NK), the total information content stored in ans.
 * 
 * @author fabiano
 *
 */
public class MainGroupAnagramsGivenArrayString {

	public static void main(String[] args) {
		List<List<String>> groupedAnagrams = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
		for (List<String> group : groupedAnagrams) {
			for (String item : group) {
				System.out.print(item + ", ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String item : strs) {
			char[] sortedItem = item.toCharArray();
			Arrays.sort(sortedItem);
			List<String> group = map.get(String.valueOf(sortedItem)); // String.valueOf is important here otherwise a
																		// memory address would return
			if (group == null) {
				group = new ArrayList<String>();
				map.put(String.valueOf(sortedItem), group);
			}
			group.add(item);
		}
		return new ArrayList<>(map.values());
	}
}
