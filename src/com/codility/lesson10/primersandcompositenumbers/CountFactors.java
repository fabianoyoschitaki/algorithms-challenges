package com.codility.lesson10.primersandcompositenumbers;

/**
 * A positive integer D is a factor of a positive integer N if there exists an
 * integer M such that N = D * M.
 * 
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition
 * (24 = 6 * 4).
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the number of its factors.
 * 
 * For example, given N = 24, the function should return 8, because 24 has 8
 * factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * - N is an integer within the range [1..2,147,483,647].
 * 
 * @author fabiano
 *
 */
public class CountFactors {

    public static void main(String[] args) {
        System.out.println(new CountFactors().solution(30));
    }

    public int solution(int N) {
        int factors = 0;
        int squareRootN = (int) Math.sqrt(N);
        if (Math.pow(squareRootN, 2) != N) {
            squareRootN++; // round up for any non-perfect squares
        } else { // perfect squares have an additional factor
            factors++;
        }

        System.out.println("N:" + N);
        for (int i = 1; i < squareRootN; i++) {
            if (N % i == 0) {
                System.out.println("i:" + i);
                factors += 2;
            }
        }

        return factors;
    }
}
