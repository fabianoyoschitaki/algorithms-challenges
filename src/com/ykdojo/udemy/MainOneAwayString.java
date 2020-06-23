package com.ykdojo.udemy;

public class MainOneAwayString {
	public static void main (String args[]) { //O(n)
		System.out.println(isOneAway("abcde", "abfde")); //change letter
		System.out.println(isOneAway("abcde", "abde")); //eat character
		System.out.println(isOneAway("abc", "abxc")); //adding character
		// NOTE: The following input values will be used for testing your solution.
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
	}

	public static boolean isOneAway(String a, String b){
		if (a.length() - b.length() >= 2 || b.length() - a.length() >= 2) {
            return false;
        } else if (a.length() == b.length()){
			return isOneAwaySameLength(a, b);
		} else if (a.length() > b.length()){
			return isOneAwayDiffLengths(a, b);
		} else {
			return isOneAwayDiffLengths(b, a);
		}
	}

	public static boolean isOneAwaySameLength(String a, String b){
		int differences = 0;
		for (int i = 0; i < a.length(); i++){
			if (a.charAt(i) != b.charAt(i) && ++differences > 1){
				return false;
			}
		}
		return true;
	}

	public static boolean isOneAwayDiffLengths(String bigger, String smaller){
		int differences = 0;
		int i = 0;
		while (i < smaller.length()){
			if (bigger.charAt(i+differences) == smaller.charAt(i)){
				i++;
			} else if(++differences > 1){
				return false;
			}
		}
		return true;
	}
}