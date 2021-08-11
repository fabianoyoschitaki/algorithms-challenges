import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: 
 * 	[ 
 * 		[-1, 0, 1], 
 * 		[-1, -1, 2] 
 * 	]
 * 
 * @author fabiano
 *
 */
public class Main3SumThreeSum {
	public static void main(String[] args) {
		for (int i = 24; i < 47; i++) {
		    System.out.println(",(1," + i + ",'ALL')");
		    System.out.println(",(2," + i + ",'ACCOUNT')");
		    System.out.println(",(3," + i + ",'OWN')");
		}

	}
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }
}
