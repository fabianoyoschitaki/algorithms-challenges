package com.codility.lesson08.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * A non-empty array A consisting of N integers is given.
 * 
 * The leader of this array is the value that occurs in more than half of the
 * elements of A.
 * 
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0],
 * A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the
 * same value.
 * 
 * For example, given array A such that:
 * 
 * - A[0] = 4 - A[1] = 3 - A[2] = 4 - A[3] = 4 - A[4] = 4 - A[5] = 2
 * 
 * we can find two equi leaders:
 * 
 * - 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose
 * value is 4. - 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same
 * leader, whose value is 4.
 * 
 * The goal is to count the number of equi leaders.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A consisting of N integers, returns the number
 * of equi leaders.
 * 
 * For example, given:
 * 
 * - A[0] = 4 - A[1] = 3 - A[2] = 4 - A[3] = 4 - A[4] = 4 - A[5] = 2
 *
 * the function should return 2, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * - N is an integer within the range [1..100,000]; - each element of array A is
 * an integer within the range [−1,000,000,000..1,000,000,000].
 * 
 * @author fabiano
 *
 */
public class EquiLeader {
    public int solution(int[] A) {
        Integer dominator = null;
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int frequency = 1;
            if (numbers.containsKey(A[i])) {
                frequency = numbers.get(A[i]) + 1;
            }
            if (frequency > A.length / 2) {
                // dominator is here
                dominator = A[i];
                break;
            }
            numbers.put(A[i], frequency);
        }

        int equiLeaders = 0;
        // no dominator, return 0
        
        if (dominator != null) {
            // let's get all indexes of the dominator, dominatorCount 
            // A = [4,3,4,4,4,2] = [{0,1}, {2,2}, {3,3}, {4, 4}]
            Map<Integer, Integer> dominatorMap = new HashMap<>();
            int dominatorCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == dominator) {
                    dominatorCount++;
                    dominatorMap.put(i, dominatorCount);
                }
            }

            // finding all equileader sequences
            int lastDominatorIndex = 0;
            int currentDominatorCount = 0;
            for (int i = 0; i < A.length - 1; i++) {
                // if it's dominator
                if (A[i] == dominator) {
                    // update index
                    lastDominatorIndex = i;
                    // get the number of dominators up to this point
                    currentDominatorCount = dominatorMap.get(i);
                } 
                // not the dominator, so let's get dominatorCount up to this point (if it exists)  
                else if (dominatorMap.get(lastDominatorIndex) != null) {
                    currentDominatorCount = dominatorMap.get(lastDominatorIndex);
                }
                
                // let's check if up to this point, we have a dominator
                int subArraySize = (i + 1);
                if (currentDominatorCount > subArraySize/2) {
                        
                    // let's check if the rest of the array has a dominator as well
                    if ((dominatorCount - currentDominatorCount) > (A.length - subArraySize)/2) {
                        equiLeaders++;
                    }
                }
            }
        }
        return equiLeaders;
    }
}
