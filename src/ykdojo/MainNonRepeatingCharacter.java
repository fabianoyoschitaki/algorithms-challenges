package ykdojo;

import java.util.HashMap;

public class MainNonRepeatingCharacter {
	
	public static void main (String args[]){
		System.out.println(nonRepeating("aabcbdddabd")); // c
		System.out.println(nonRepeating("xxyz")); // y being the first one
		System.out.println(nonRepeating("aabb")); // null as there's no non-repeating character
	}

	public static Character nonRepeating(String value){
		HashMap<Character, Integer> mapCount = new HashMap<>();
		for (int i = 0; i < value.length(); i++){
			if (!mapCount.containsKey(value.charAt(i))){
				mapCount.put(value.charAt(i), 1);
			} else {
				int count = mapCount.get(value.charAt(i)) + 1;
				mapCount.put(value.charAt(i), count);
			}
		}
		for (int i = 0; i < value.length(); i++){
			if (mapCount.get(value.charAt(i)) == 1){
				return value.charAt(i);
			}
		}
		return null;
	}
}