package com.codility.lesson09.maximumsliceproblem;

/**
 * An array A consisting of N integers is given. It contains daily prices of a
 * stock share for a period of N consecutive days. If a single share was bought
 * on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such
 * transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise,
 * the transaction brings loss of A[P] − A[Q].
 * 
 * For example, consider the following array A consisting of six elements such
 * that:
 * 
 * - A[0] = 23171 
 * - A[1] = 21011 
 * - A[2] = 21123 
 * - A[3] = 21366 
 * - A[4] = 21013 
 * - A[5] = 21367
 * 
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur
 * because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4
 * and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 −
 * 21013 = 354. Maximum possible profit was 356. It would occur if a share was
 * bought on day 1 and sold on day 5.
 * 
 * Write a function,
 * 
 *      class Solution { public int solution(int[] A); }
 * 
 * that, given an array A consisting of N integers containing daily prices of a
 * stock share for a period of N consecutive days, returns the maximum possible
 * profit from one transaction during this period. The function should return 0
 * if it was impossible to gain any profit.
 * 
 * For example, given array A consisting of six elements such that:
 * 
 * - A[0] = 23171 
 * - A[1] = 21011 
 * - A[2] = 21123 
 * - A[3] = 21366 
 * - A[4] = 21013 
 * - A[5] = 21367 
 * 
 * the function should return 356, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..400,000]; each element of array A is an
 * integer within the range [0..200,000].
 * 
 * @author fabiano
 *
 */
public class MaxProfit {
    
    public static void main(String[] args) {
        new MaxProfit().solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367});
    }
    public int solution(int[] A) {
        // for empty array or 1 element array, no profit can be realized
        if (A.length < 2)
            return 0; 

        // convert profit table to delta table so can use max slice technique
        int[] deltaA = new int[A.length];
        deltaA[0] = 0;
        
        // [0, -2160, 112, 243, -353, 354]
        for (int i = 1; i < A.length; i++) {
            deltaA[i] = A[i] - A[i-1];
            System.out.println(deltaA[i]);
        }

        int absoluteMax = deltaA[0];
        int localMax = deltaA[0];
        int nextSum = 0;

        for (int i = 1; i < deltaA.length; i++) {
            nextSum = localMax + deltaA[i];
            localMax = Math.max(deltaA[i], nextSum);
            absoluteMax = Math.max(absoluteMax, localMax);
        }
        
        // currentDelta = -2160
        // nextSum = 0 + -2160 (-2160)
        // localMax = 0 : -2160 (0)
        // absoluteMax = 0 : 0 (0)
        
        // currentDelta = 112
        // nextSum = 0 + 112 (112)
        // localMax = 0 : 112 (112)
        // absoluteMax = 0 : 112 (112)
        
        // currentDelta = 243
        // nextSum = 112 + 243 (355)
        // localMax = 243 : 355 (355)
        // absoluteMax = 112 : 355 (355)
        
        // currentDelta = -353
        // nextSum = 355 + -353 (2)
        // localMax = -353 : 2 (2)
        // absoluteMax = 355 : 2 (355)
        
        // currentDelta = 354
        // nextSum = 2 + 354 (356)
        // localMax = 354 : 356 (356)
        // absoluteMax = 355 : 356 (356)
        
        if (absoluteMax > 0)
            return absoluteMax;

        return 0;
    }
}
