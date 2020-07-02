package com.codility.lesson07.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * 
 * - S is empty;
 * - S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * - S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 *      class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * - N is an integer within the range [0..200,000];
 * - string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * 
 * @author fabiano
 *
 */
public class Brackets {
    public int solution(String S) {
        Map<Character, Character> brackets = new HashMap<Character, Character>(){{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};
        
        Stack<Character> openings = new Stack<>();
        for (char c : S.toCharArray()){
            if (brackets.keySet().contains(c)){
                openings.push(c);
            } else if (brackets.values().contains(c)){
                // if closing bracket is not pair of latest opening
                if (openings.empty() || brackets.get(openings.pop()) != c){
                    return 0;
                }
            }
        }
        return openings.empty() ? 1 : 0;
    }
}
