package com.ykdojo.udemy;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MainCommonElementsInTwoSortedArrays {
	public static void main(String args[]){
		int [] a = {1,3,4,6,7,9};
		int [] b = {1,2,4,5,9,10};
		// int [] result = commonElements(a,b);
		Integer [] result = commonElements(a,b);
		System.out.println(Arrays.toString(result));
	}

	// public static int[] commonElements(int [] a, int [] b){
	public static Integer[] commonElements(int [] a, int [] b){
		int indexA = 0, indexB = 0;
		List<Integer> result = new ArrayList<>();
		while (indexA < a.length && indexB < b.length){
			if (a[indexA] == b[indexB]){
				result.add(a[indexA]);
				indexA++;
				indexB++;
			} else if (a[indexA] < b[indexB]){
				indexA++;
			} else {
				indexB++;
			}
		}
		// return result.stream().mapToInt(i -> i).toArray();
		return result.toArray(new Integer[result.size()]);
	}
}