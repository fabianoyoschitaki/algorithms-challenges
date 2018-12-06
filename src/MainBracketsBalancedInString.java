
// Write a function that returns true if the brackets in a given string are balanced.

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class MainBracketsBalancedInString {
	public static void main(String[] args) {
		MainBracketsBalancedInString m = new MainBracketsBalancedInString();
		System.out.println("(a[0]+b[2c[6]]){24+53}            passed:" + m.isStringBalanced("(a[0]+b[2c[6]]){24+53}"));
		System.out.println("f(e(d))                    passed:" + m.isStringBalanced("f(e(d))"));
		System.out.println("[()]{}([])                 passed:" + m.isStringBalanced("[()]{}([])"));
		System.out.println("((b)                       passed:" + !m.isStringBalanced("((b)"));
		System.out.println("(c]                        passed:" + !m.isStringBalanced("(c]"));
		System.out.println("{(a[])                     passed:" + !m.isStringBalanced("{(a[])"));
		System.out.println("([)]                       passed:" + !m.isStringBalanced("([)]"));
		System.out.println("[({{}}])                   passed:" + !m.isStringBalanced("[({{}}])"));
		System.out.println(")(                         passed:" + !m.isStringBalanced(")("));
		System.out.println("                         passed:" + m.isStringBalanced(""));
	}

	private static Map<Character, Character> BRACKETS = new HashMap<>();
	static {
		BRACKETS.put('(', ')');
		BRACKETS.put('[', ']');
		BRACKETS.put('{', '}');
		BRACKETS.put('<', '>');
	}
	
	public boolean isStringBalanced (String sentence){
		if (sentence == null || sentence.isEmpty()) 
			return false;
		
		Stack<Character> openings = new Stack<>();
		for (int pos = 0; pos < sentence.length(); pos++) {
			if (BRACKETS.keySet().contains(sentence.charAt(pos))){
				openings.add(sentence.charAt(pos));
			} else if (BRACKETS.values().contains(sentence.charAt(pos))
			 && (openings.isEmpty() || !BRACKETS.get(openings.pop()).equals(sentence.charAt(pos)))) {
				return false;
			}
		}
		return openings.isEmpty();
	}
}
