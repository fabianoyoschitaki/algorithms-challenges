package com.ykdojo.udemy;

import java.util.HashMap;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * return [0, 1].
 * 
 * @author fabiano
 *
 */
public class MainFindTwoNumbersInArrayThatAddUpToSpecificTarget {
	public static void main (String args []){
		int [] numbers = {3, 9, 15, 20, 1, 2, 8};
		int [] sumUpTo16 = twoSum(numbers, 16);
		System.out.println(sumUpTo16[0] + " and " + sumUpTo16[1]);
		int [] sumUpTo28 = twoSum(numbers, 28);
		System.out.println(sumUpTo28[0] + " and " + sumUpTo28[1]);
	}	

	public static int[] twoSum(int [] numbers, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++){
			if (map.containsKey(target-numbers[i])){
				return new int[]{map.get(target-numbers[i]), i};
			} else {
				map.put(numbers[i], i);
			}
		}
		return null;
	}
}
