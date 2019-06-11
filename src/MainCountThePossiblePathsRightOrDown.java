
public class MainCountThePossiblePathsRightOrDown {

	static int EXECUTIONS, DYN_EXECUTIONS;
	
	public static void main(String[] args) {
		Integer rows = Integer.parseInt(args[0]);
		Integer cols = Integer.parseInt(args[1]);
		
		System.out.println("====== Normal Approach ======");
		int count = countPaths(new boolean[rows][cols], 0, 0);
		System.out.println("Possible Paths for grid(" + rows + "," + cols + "): " + count);
		System.out.println("Total method calls: " + EXECUTIONS);
		
		System.out.println("\n\n====== Dynamic Approach ======");
		int dynCount = dynCountPaths(new boolean[rows][cols], 0, 0, new Integer[rows][cols]);
		System.out.println("(Dynamic) Possible Paths for grid(" + rows + "," + cols + "): " + dynCount);
		System.out.println("(Dynamic) Total method calls: " + DYN_EXECUTIONS);
	}
	
	/**
	 * No Dynamic Programming approach
	 * 
	 * @param grid
	 * @param row
	 * @param col
	 * @return
	 */
	static int countPaths(boolean[][] grid, int row, int col) {
		EXECUTIONS++;
		if (!validSquare(grid, row, col)){
			System.out.println("Trying at " + row + "," + col + ": no way");
			return 0;
		}
		if (isAtEnd(grid, row, col)) {
			System.out.println("Trying at " + row + "," + col + ": yes!");
			return 1;
		}
		System.out.println("Trying at " + row + "," + col + ": keep going");
		return countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
	}
	
	/**
	 * Memoization Dynamic Programming approach
	 * 
	 * @param grid
	 * @param row
	 * @param col
	 * @return
	 */
	static int dynCountPaths(boolean[][] grid, int row, int col, Integer[][] paths) {
		DYN_EXECUTIONS++;
		if (!validSquare(grid, row, col)){
			System.out.println("(Dynamic) Trying at " + row + "," + col + ": no way");
			return 0;
		}
		if (isAtEnd(grid, row, col)) {
			System.out.println("(Dynamic) Trying at " + row + "," + col + ": yes!");
			return 1;
		}
		if (paths[row][col] == null) {
			System.out.println("(Dynamic) Calculating for [" + row + "][" + col + "]");
			paths[row][col] = dynCountPaths(grid, row+1, col, paths) + dynCountPaths(grid, row, col+1, paths);
			System.out.println("(Dynamic) Calculated! for [" + row + "][" + col + "]: " + paths[row][col]);
		} else {
			System.out.println("(Dynamic) We have cache for [" + row + "][" + col + "]: " + paths[row][col]);
		}
		return paths[row][col];
	}

	private static boolean isAtEnd(boolean[][] grid, int row, int col) {
		return grid.length == row+1 && grid[0].length == col+1;
	}

	private static boolean validSquare(boolean[][] grid, int row, int col) {
		return grid.length >= row+1 && grid[0].length >= col+1 && !grid[row][col];
	}
}
