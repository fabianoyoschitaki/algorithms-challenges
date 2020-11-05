package leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * @author fabiano
 *
 */
public class MergeSortedArray {
    class Solution {
        public int[] merge(int[] nums1, int m, int[] nums2, int n) {
            int lastIndex = nums1.length-1;
            int mIndex = m-1;
            int nIndex = n-1;
            while (lastIndex >= 0){
                if (nIndex < 0 || mIndex >= 0 && nums1[mIndex] >= nums2[nIndex]){
                    nums1[lastIndex--] = nums1[mIndex--];
                } else {
                    nums1[lastIndex--] = nums2[nIndex--];
                }
            }
            return nums1;
        }
    }
    
    public static void main(String[] args) {
        for (int i: new MergeSortedArray().new Solution().merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3)) {
            System.out.println(i);
        }
    }
}
