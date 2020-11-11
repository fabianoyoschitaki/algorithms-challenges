package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/solution/
 * @author fabiano
 *
 */
public class IntersectionOfTwoArraysII {
    // time complexity O(n+m)
    // space complexity O(min(n,m)) as we use the hashmap to store the numbers and counts from smaller array
    public int[] intersect(int[] nums1, int[] nums2) {
        // let's make nums1 the smaller array, because we'll make inplace changes
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        
        // map to keep track of all numbers inside nums1 and their counts
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums1){
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        
        // how many intersections we'll have
        int intersections = 0;
        for (int j : nums2){
            int cont = m.getOrDefault(j, 0);
            // is there intersection with nums1?
            if (cont > 0){
                // change smaller array nums1, after all max intersections = nums1.length;
                nums1[intersections++] = j;
                // make sure to decrease count of map
                m.put(j, cont-1);
            }
        }
        // return range of array nums1 since 0 to number of intersections
        return Arrays.copyOfRange(nums1, 0, intersections);
    }
}
