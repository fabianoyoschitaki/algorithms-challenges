package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 * 
 * @author fabiano
 *
 */
public class MoveZeroes {
    // mine
    public void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;
        int zeroIndex = 0;
        int nonZeroIndex = zeroIndex+1;
        while (nonZeroIndex < nums.length && zeroIndex < nums.length){
            if (nums[zeroIndex] != 0){
                zeroIndex++;
            } else {
                if (nonZeroIndex <= zeroIndex){
                    nonZeroIndex = zeroIndex+1;
                }
                if (nonZeroIndex >= nums.length){
                    return;
                }
                while (nums[nonZeroIndex] == 0){
                    nonZeroIndex++;
                    if (nonZeroIndex >= nums.length){
                        return;
                    }   
                }
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
                nonZeroIndex++;
            }
        }
    }
    
    public void moveZeroes2(int[] nums) {
        int i = 0;
        int j = 0;
     
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
     
            j++;
        }
     
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
