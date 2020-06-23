package com.codility.lesson04.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a demo task.
 * 
 * Write a function:
 * 
 *      class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000]; each element of array A is an
 * - integer within the range [−1,000,000..1,000,000].
 * 
 * @author fabiano
 *
 */
public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> existingNumbers = new HashSet<>();
        for (int i = 0 ; i < A.length ; i++) {
            if (A[i] > 0) {
                existingNumbers.add(A[i]);
            }
        }
        int missingNumber = 1;
        while (existingNumbers.contains(missingNumber)) {
            missingNumber++;
        }
        return missingNumber;
    }
}
