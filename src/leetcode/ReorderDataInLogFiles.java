package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * 
 * @author fabiano
 */
public class ReorderDataInLogFiles {

    /**
     * Let N be the number of logs in the list and M be the maximum length of a
     * single log.
     * 
     * Time Complexity: O(M⋅N⋅log⁡N)
     * 
     * - The sorted() in Python is implemented with the Timsort algorithm whose time
     * complexity is O(N⋅log⁡N).
     * 
     * - Since the keys of the elements are basically the logs itself, the comparison
     * between two keys can take up to O(M) time.
     * 
     * - Therefore, the overall time complexity of the algorithm is
     * O(M⋅N⋅log⁡N).
     * 
     * Space Complexity: O(M⋅N)
     * 
     * - First, we need O(M⋅N) space to keep the keys for
     * the log.
     * 
     * - In addition, the worst space complexity of the Timsort algorithm is
     * O(N), assuming that the space for each element is
     * O(1). Hence we would need O(M⋅N) space to hold the intermediate values for sorting.
     * 
     * - In total, the overall space complexity of the algorithm is
     * O(M⋅N+M⋅N)=O(M⋅N).
     * 
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);

                char c1 = split1[1].charAt(0);
                char c2 = split2[1].charAt(0);

                // both strings
                if (!Character.isDigit(c1) && !Character.isDigit(c2)) {
                    int comparation = split1[1].compareTo(split2[1]);
                    // if it's the same, then compare identifiers
                    if (comparation == 0) {
                        return split1[0].compareTo(split2[0]);
                    }
                    return comparation;
                } else if (Character.isDigit(c1) && !Character.isDigit(c2)) {
                    return 1;
                } else if (!Character.isDigit(c1) && Character.isDigit(c2)) {
                    return -1;
                } else { // both numbers
                    return 0;
                }
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
                "let3 art zero" };
        String[] reorderLogFiles = new ReorderDataInLogFiles().reorderLogFiles(logs);
        for (String log : reorderLogFiles) {
            System.out.println(log);
        }
    }
}
