package leetcode;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author fabiano
 *
 */
public class ValidParenthesis {

    static Map<Character, Character> BRACKETS = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public boolean isValid(String s) {
        Stack<Character> openings = new Stack<>();
        for (char c : s.toCharArray()) {
            if (BRACKETS.keySet().contains(c)) {
                openings.push(c);
            } else if (BRACKETS.values().contains(c)) {
                if (openings.isEmpty() || BRACKETS.get(openings.pop()) != c) {
                    return false;
                }
            }
        }
        return openings.isEmpty();
    }
}
