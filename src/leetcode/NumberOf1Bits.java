package leetcode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * @author fabiano
 *
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int ones = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }

    /**
     * Loop and Flip
     * 
     * Approach #1 (Loop and Flip) [Accepted]
     ** 
     * Algorithm**
     * 
     * The solution is straight-forward. We check each of the 32 bits of the number.
     * If the bit is 1, we add one to the number of 1-bits.
     * 
     * We can check the ith bit of a number using a bit mask. We start with a mask
     * m=1, because the binary representation of 1 is,
     * 
     * 0000 0000 0000 0000 0000 0000 0000 0001
     * 
     * Clearly, a logical AND between any number and the mask 1 gives us the least
     * significant bit of this number. To check the next bit, we shift the mask to
     * the left by one.
     * 
     * 0000 0000 0000 0000 0000 0000 0000 0010
     * 
     * And so on.
     * 
     * Complexity Analysis
     * 
     * The run time depends on the number of bits in n. Because n in this piece
     * of code is a 32-bit integer, the time complexity is O(1).
     * 
     * The space complexity is O(1), since no additional space is allocated.
     * 
     * @param n
     * @return
     */
    public int hammingWeightLoopAndFlip(int n) {
        int bits1 = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits1++;
            }
            mask <<= 1;
        }
        return bits1;
    }
    
    public int hammingWeightBitManipulationTrick(int n) {
        int bits1 = 0;
        while (n != 0) {
            System.out.println(n + " & " + (n-1) + " = " + Integer.toBinaryString(n) + " & " + Integer.toBinaryString(n-1));
            n = n & n-1;
        }
        return bits1;
    }

    public static void main(String[] args) {
//        System.out.println(new NumberOf1Bits().hammingWeightLoopAndFlip(96));
        System.out.println(new NumberOf1Bits().hammingWeightBitManipulationTrick(96));
        
    }
}
