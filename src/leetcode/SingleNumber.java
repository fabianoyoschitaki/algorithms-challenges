package leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * @author fabiano
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums){
            System.out.print("Single is " + single + ", num is " + num);
            single = single ^ num;
            System.out.println(" and new Single is " + single);
        }
        return single;
    }
}
