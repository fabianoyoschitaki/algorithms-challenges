package com.leetcode.amazon.arraysandstrings;

/**
 * 
 * @author fabiano
 *
 */
public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++){
            int oddLeft = i-1;
            int oddRight = i+1;
            int evenLeft = i-1;
            int evenRight = i;
            boolean checkOdd = true;
            boolean checkEven = true;
            String largestOdd = s.substring(i, i+1);
            String largestEven = "";
            while (checkOdd || checkEven){
                if (checkOdd){
                    if (oddLeft >= 0 && oddRight < s.length()){
                        if (s.charAt(oddLeft) == s.charAt(oddRight)){
                            largestOdd = s.substring(oddLeft, oddRight+1);
                            oddLeft--;
                            oddRight++;
                        } else {
                            checkOdd = false;
                        }   
                    } else {
                        checkOdd = false;
                    }
                }
                if (checkEven){
                    if (evenLeft >= 0 && evenRight < s.length()){
                        if (s.charAt(evenLeft) == s.charAt(evenRight)){
                            largestEven = s.substring(evenLeft, evenRight+1);
                            evenLeft--;
                            evenRight++;
                        } else {
                            checkEven = false;    
                        }
                    } else {
                        checkEven = false;
                    }
                }
            }
            if (largestOdd.length() > largestEven.length() && largestOdd.length() > longestPalindrome.length()){
                longestPalindrome = largestOdd;
            } else if (largestEven.length() > largestOdd.length() && largestEven.length() > longestPalindrome.length()){
                longestPalindrome = largestEven;
            }
        }
        return longestPalindrome;
    }
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
