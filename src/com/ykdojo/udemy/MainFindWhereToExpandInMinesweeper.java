package com.ykdojo.udemy;

import java.util.ArrayDeque;

public class MainFindWhereToExpandInMinesweeper {
	
	public static void main(String args[]){
		int [][] field = {{-1, 1, 0, 0}
						 ,{ 1, 1, 0, 0}
						 ,{ 0, 0, 1, 1}
						 ,{ 0, 0, 1,-1}};
		int nRows = 4;
		int nCols = 4;
		int givenI = 1;
		int givenJ = 2;

		int [][] result = click(field, nRows, nCols, givenI, givenJ);
		print(result);
	}

	public static int[][] click(int [][] field, int nRows, int nCols, int givenI, int givenJ){
		ArrayDeque<int[]> toCheck = new ArrayDeque<int[]>();
		if (field[givenI][givenJ] == 0){
			field[givenI][givenJ] = -2; // already reviews
			int [] coordinates = {givenI, givenJ};
			toCheck.add(coordinates); // added to 
		} else {
			return field; // return as it is
		}
		while (!toCheck.isEmpty()){
			int [] current = toCheck.remove();
			int currentI = current[0];
			int currentJ = current[1];
			for (int i = currentI-1; i <= currentI+1; i++){
				for (int j = currentJ-1; j <= currentJ+1; j++){
					if (i >= 0 && i < nRows && j >= 0 && j < nCols && field[i][j] == 0){
						field[i][j] = -2;
						int [] coordinates = {i,j};
						toCheck.add(coordinates); // added to 
					}
				}
			}
		}
		return field;
	}

	public static void print(int [][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}