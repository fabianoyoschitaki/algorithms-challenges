/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * @author fabiano
 *
 */
public class MainRotating2DArray {
	public static void main(String args[]) {
		int[][] field = { { 1, 2, 3, 4, 5 } // 13, 9, 5, 1
				, { 6, 7, 8, 9, 10 } // 14,10, 6, 2
				, { 11, 12, 13, 14, 15 } // 15,11, 7, 3
				, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };// 16,12, 8, 4

		// 0,0 -> 0,3 | 0,1 -> 1,3 | 0,2 -> 2,3 | 0,3 -> 3,3
		// 1,0 -> 0,2 | 1,1 -> 1,2 | 1,2 -> 2,2 | 1,3 -> 3,2
		// 2,0 -> 0,1 | 2,1 -> 1,1 | 2,2 -> 2,1 | 2,3 -> 3,1
		// 3,0 -> 0,0 | 3,1 -> 1,0 | 3,2 -> 2,0 | 3,3 -> 3,0
		int size = 5;
		// field = rotateOutOfPlace(field, size);
		// print(field);
		field = rotateInPlace(field, size);
		print(field);
	}

	public static int[][] rotateOutOfPlace(int[][] field, int size) {
		int rotated[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rotated[j][size - i - 1] = field[i][j];
			}
		}
		return rotated;
	}

	public static int[][] rotateInPlace(int[][] field, int size) {
		for (int i = 0; i < (size / 2 + size % 2); i++) {
			for (int j = 0; j < size / 2; j++) {
				System.out.println("checking position [" + i + "][" + j + "] = " + field[i][j]);
				int[] temp = new int[4];
				int currentI = i;
				int currentJ = j;
				for (int k = 0; k < 4; k++) {
					temp[k] = field[currentI][currentJ];
					System.out.println(
							"adding to temp [" + currentI + "][" + currentJ + "] = " + field[currentI][currentJ]);
					int[] newCoordinates = rotateSub(currentI, currentJ, size);
					currentI = newCoordinates[0];
					currentJ = newCoordinates[1];
					System.out.println("new coordinates: [" + currentI + "][" + currentJ + "]");
				}
				System.out.println(" after storing at temp, these are new i and j: " + currentI + "-" + currentJ);
				for (int k = 0; k < 4; k++) {
					field[currentI][currentJ] = temp[(k + 3) % 4];
					int[] newCoordinates = rotateSub(currentI, currentJ, size);
					currentI = newCoordinates[0];
					currentJ = newCoordinates[1];
				}
				print(field);
			}
		}
		return field;
	}

	public static int[] rotateSub(int i, int j, int n) {
		int[] newCoordinates = new int[2];
		newCoordinates[0] = j;
		newCoordinates[1] = n - 1 - i;
		return newCoordinates;
	}

	public static void print(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] > 9) {
					System.out.print(matrix[i][j] + " ");
				} else {
					System.out.print(" " + matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
