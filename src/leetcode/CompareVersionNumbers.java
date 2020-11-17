package leetcode;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/502/
 * 
 * @author fabiano
 *
 */
public class CompareVersionNumbers {
    /**
     * Time complexity : O(N+M+max⁡(N,M)), where N and M are lengths of input strings. 
     * 
     * Space complexity : O(N+M) to store arrays nums1 and nums2.
     * 
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int v1Int = 0;
            int v2Int = 0;
            if (v1.length > i) {
                v1Int = Integer.parseInt(v1[i]);
            }
            if (v2.length > i) {
                v2Int = Integer.parseInt(v2[i]);
            }
            if (v1Int != v2Int) {
                return v1Int > v2Int ? 1 : -1;
            }
        }
        return 0;
    }
}
