package com.codility.lesson06.sorting;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet
 * (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * 
 * For example, array A such that:
 * 
 * - A[0] = -3 
 * - A[1] = 1 
 * - A[2] = 2 
 * - A[3] = -2 
 * - A[4] = 5 
 * - A[5] = 6 
 * 
 * contains the following example triplets:
 * 
 * (0, 1, 2), product is −3 * 1 * 2 = −6 (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60 Your goal is to find the maximal product
 * of any triplet.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A, returns the value of the maximal product of
 * any triplet.
 * 
 * For example, given array A such that:
 * 
 * - A[0] = -3 
 * - A[1] = 1 
 * - A[2] = 2 
 * - A[3] = -2 
 * - A[4] = 5 
 * - A[5] = 6
 * 
 * return 60, as the product of triplet (2, 4, 5) is maximal.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [3..100,000]; each element of array A is an
 * integer within the range [−1,000..1,000].
 * 
 * @author fabiano
 *
 */
public class MaxProductOfThree {
     public int solution(int[] A) {
         /**
          * When we sort an array there are two possible options for the largest product
          * 1) The largest (the last) three elements
          * 2) Combination of two smallest and the largest elements
          * Logic of (1): Obvious
          * Logic of (2): A pair of negatives multiplied returns a positive, which in combination with 
          * the largest positive element of the array can give the max outcome.
          * Therefore we return the max of options (1) and (2)
          */
         int N = A.length;
         Arrays.sort(A); // O(N*log(N))
         int lastTreeElement = A[N-1]*A[N-2]*A[N-3];
         int firstTwoAndLastElement = A[0] * A[1] * A[N-1];
         return Math.max(lastTreeElement, firstTwoAndLastElement);
     }  

}
