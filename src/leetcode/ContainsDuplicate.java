package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * 
 * @author fabiano
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums){
            if (numbers.contains(num)){
                return true;
            }
            numbers.add(num);
        }
        return false;
    }
}
