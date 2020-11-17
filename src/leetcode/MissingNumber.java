package leetcode;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2971/
 * 
 * @author fabiano
 *
 */
public class MissingNumber {
    /**
     * Gauss Formula (n * (n+1)) / 2
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length * (nums.length+1))/2;
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }
    
    /**
     * 
     * Time complexity : O(n)
     * Assuming that XOR is a constant-time operation, this algorithm does constant work on N iterations, 
     * so the runtime is overall linear.
     * 
     * Space complexity : O(1)
     * This algorithm allocates only constant additional space.
     * 
     * @param nums
     * @return
     */
    public int missingNumberWithBitManipulation(int[] nums) {
        int missingNumber = 0;
        for (int i : nums){
            missingNumber ^= i;
        }
        for (int i = 1; i <= nums.length; i++){
            missingNumber ^= i;
        }
        return missingNumber;
    }
}
