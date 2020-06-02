package ykdojo;

import java.util.Map;
import java.util.HashMap;

public class MainMostFrequentlyOccurringItemInArray {
	
	public static void main(String args []){
		int [] array = new int[]{1,3,1,3,2,1};
		System.out.println(mostFrequent(array));
	}

	public static int mostFrequent(int [] array){
		int mostFrequent = array[0];
		int frequency = 0;
		Map<Integer, Integer> mapCount = new HashMap<>();
		for (int i = 0; i < array.length; i++){
			if (mapCount.get(array[i]) == null){
				mapCount.put(array[i], 1);
			} else {
				mapCount.put(array[i], mapCount.get(array[i])+1);
			}
			if (frequency < mapCount.get(array[i])){
				frequency = mapCount.get(array[i]);
				mostFrequent = array[i];
			}
		}
		return mostFrequent;
	}
}