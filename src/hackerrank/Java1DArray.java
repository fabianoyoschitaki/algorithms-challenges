package hackerrank;
/**
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 * Level: Medium
 * 
 * @param args
 */
public class Java1DArray {
    public static boolean canWin(int leap, int[] game) {
        boolean[] visited = new boolean[game.length];
        int pos = 0;
        return canWin(pos, leap, game, visited);
    }
    
    public static boolean canWin(int i, int leap, int[] game, boolean[] visited){
        visited[i] = true;
        if (i == game.length - 1 || i + leap >= game.length){
            return true;
        }
        boolean canWinBack = false, canWinFront = false, canWinLeap = false;
        int backPos = i - 1, frontPos = i + 1, leapPos = i + leap;
        if (backPos > 0 && !visited[backPos] && game[backPos] == 0){
            canWinBack = canWin(backPos, leap, game, visited);
        }
        if (!visited[frontPos] && game[frontPos] == 0){
            canWinFront = canWin(frontPos, leap, game, visited);
        }
        if (!visited[leapPos] && game[leapPos] == 0){
            canWinLeap = canWin(leapPos, leap, game, visited);
        }
        return (canWinBack || canWinFront || canWinLeap);
    }
}
