package com.ykdojo.udemy;

public class MainAssignNumbersInMineSweeper {
	
	public static void main (String args []){

		int [][] bombs = {{0,0},{0,1},{0,2}}; //row,column, there's no duplicates
		int nRows = 3;
		int nColumns = 4;
		int [][] result = mineSweeper(bombs, nRows, nColumns);
		print(result);
	}

	public static int[][] mineSweeper(int [][] bombs, int nRows, int nCols){
		int [][] matrix = new int [nRows][nCols];
		for (int i = 0; i < bombs.length; i++){
			int bombRow = bombs[i][0];
			int bombCol = bombs[i][1];
			matrix[bombRow][bombCol] = -1;
			for (int a = bombRow-1; a <= bombRow +1; a++){
				for (int b = bombCol-1; b <= bombCol+1; b++){
					if (a >= 0 && a < nRows && b >= 0 && b < nCols && matrix[a][b] != -1){
						matrix[a][b] = matrix[a][b]+1;
					}
				}
			}
		}
		return matrix;
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