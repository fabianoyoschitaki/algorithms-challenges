package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 * 
 * @author fabiano
 *
 */
public class BestTimeToBuyAndSellStockII {
    
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        
        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 1;
        while (sellIndex < prices.length){
            if (prices[buyIndex] < prices[sellIndex]){
                maxProfit += prices[sellIndex] - prices[buyIndex];
            } 
            buyIndex++;
            sellIndex++;
        }
        return maxProfit;
    }
    
    public int bestSolutionRemoveDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
