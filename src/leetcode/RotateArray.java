package leetcode;

/**
 * https://leetcode.com/problems/rotate-array/submissions/
 * 
 * @author fabiano
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int changes = 0;
        int currentIndex = 0;
        int temp = nums[currentIndex];
        while (changes < nums.length) {
            int newIndex = (currentIndex + k) % nums.length;
            nums[currentIndex] = temp;
            temp = nums[newIndex];
            nums[newIndex] = nums[currentIndex];
            currentIndex = newIndex;
            
            changes++;
        }
    }
}
