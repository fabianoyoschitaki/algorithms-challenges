package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author fabiano
 *
 */
public class TwoSum {
    
    private static final int[] NUMS = new int[] {2, 7, 11, 15};
    private static final int TARGET = 9;

    public static void main(String[] args) {
        int [] response = twoSum(NUMS, TARGET);
        System.out.println(response[0] + " and " + response[1] + " sums up to " + TARGET + ": " + NUMS[response[0]] + " + " + NUMS[response[1]]);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
