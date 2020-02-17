/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author fabiano
 *
 */
public class MainContainerWithMostWater {
	public static int maxArea(int[] height) {
		int maxArea = 0;
		int ini = 0;
		int end = height.length-1;
		while (ini < end) {
			maxArea = Math.max(maxArea, Math.min(height[ini], height[end]) * (end-ini));
			if (height[ini] < height[end]) {
				ini++;
			} else {
				end--;
			}
		}
		return maxArea;
	}

	public static void main(String args[]) {
		int area = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
		System.out.println(area);
	}
}
