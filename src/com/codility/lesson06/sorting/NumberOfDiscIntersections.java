package com.codility.lesson06.sorting;

import java.util.Arrays;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
 * A of N non-negative integers, specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * 
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * 
 * The figure below shows discs drawn for N = 6 and A as follows:
 * 
 * - A[0] = 1 
 * - A[1] = 5 
 * - A[2] = 2 
 * - A[3] = 1 
 * - A[4] = 4 
 * - A[5] = 0
 * 
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * 
 * - discs 1 and 4 intersect, and both intersect with all the other discs; 
 * - disc 2 also intersects with discs 0 and 3. Write a function:
 * 
 *      class Solution { public int solution(int[] A); }
 * 
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should return
 * −1 if the number of intersecting pairs exceeds 10,000,000.
 * 
 * Given array A shown above, the function should return 11, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * - N is an integer within the range [0..100,000]; 
 * - each element of array A is an integer within the range [0..2,147,483,647].
 * 
 * @author fabiano
 *
 */
public class NumberOfDiscIntersections {
    
    public static void main(String[] args) {
        int i = 1;
        long od = i + Long.valueOf(Integer.MAX_VALUE);
        System.out.println(od);
    }
    public int solution(int[] A) {
        int intersections = 0;
        long [] openDisks = new long[A.length];
        long [] closeDisks = new long[A.length];
        for (int i = 0; i < A.length; i++){
            // cast needed to not overflow integer! cast only first operand is enough, 
            // even operand = 1 and operand = 2147483647, because long + int autocasting to long.
            openDisks[i] = (long)i-A[i];
            closeDisks[i] = (long)i+A[i];
        }
        
        Arrays.sort(openDisks);
        Arrays.sort(closeDisks);
    
        int currentOpenDisks = 0;
        int currentCloseDisksIndex = 0;
        for (long i : openDisks){
            while (i > closeDisks[currentCloseDisksIndex]){
                currentOpenDisks--;
                currentCloseDisksIndex++;
            }
            intersections += currentOpenDisks;
            if (intersections > 10_000_000){
                return -1;
            }
            currentOpenDisks++;
        }
        return intersections;
    }
}
