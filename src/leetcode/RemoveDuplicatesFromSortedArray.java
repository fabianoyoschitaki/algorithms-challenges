package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 * 
 * @author fabiano
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevIndex = 0;
        int currentIndex = 1;
        boolean replace = false;
        while (currentIndex < nums.length){
            if (nums[prevIndex] == nums[currentIndex]){
                replace = true;
                currentIndex++;
            } else {
                if (replace){
                    replace = false;
                    prevIndex++;
                    nums[prevIndex] = nums[currentIndex];
                } else {
                    prevIndex++;
                    currentIndex++;
                }
            }
        }
        System.out.println("Answer: " + prevIndex);
        return prevIndex+1;
    }
    
    public int bestSolutionRemoveDuplicates(int[] nums) {
        if (nums.length == 0) 
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
