package leetcode;

/**
 * https://leetcode.com/problems/plus-one/submissions/
 * 
 * @author fabiano
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        // if we didn't return, that means it's all 9's! return new array with size + 1 and only first digit is 1 (as in 999 -> 1000)
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}   
