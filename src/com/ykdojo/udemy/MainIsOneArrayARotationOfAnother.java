package com.ykdojo.udemy;

public class MainIsOneArrayARotationOfAnother {
	public static void main (String [] args){
		int a [] = {0,1};
		int b [] = {1,0};
		boolean result = isRotation(a, b);
		System.out.println(result);
	}

	public static boolean isRotation(int [] a, int [] b){
		if (a.length != b.length)
			return false;
		int offset = -1;
		for (int i = 0; i < b.length; i++){
			if (a[0] == b[i]){
				offset = i;
				break;
			}
		}
		if (offset == -1)
			return false;

		for (int i = 0; i < a.length; i++){
			int indexB = (i+offset) % b.length;
			if (a[i] != b[indexB]){
				return false;
			}
		}
		return true;
	}
}
