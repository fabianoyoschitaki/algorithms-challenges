/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character. Assume we
 * are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is out
 * of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is
 * returned.
 * 
 * @author fabiano
 *
 */
public class MainStringToIntegerATOI {
	public static void main(String[] args) {

		// Output: 42
		System.out.println(atoi("42"));

		// Output: -42
		// Explanation: The first non-whitespace character is '-', which is
		// the minus sign.Then take as many numerical digits as possible, which gets 42.
		System.out.println(atoi("   -42"));

		// Output: 4193
		// Explanation: Conversion stops at digit '3' as the next character
		// is not a numerical digit.
		System.out.println(atoi("4193 with words"));

		// Output: 0
		// Explanation: The first non-whitespace character is 'w', which is
		// not a numerical digit or a +/- sign. Therefore no valid conversion could be
		// performed.
		System.out.println(atoi("words and 987"));

		// Output: -2147483648
		// Explanation: The number "-91283472332" is out of the range of a 32-bit signed
		// integer.Thefore INT_MIN (−231) is returned.
		System.out.println(atoi("-91283472332"));
	}

	private static int atoi(String str) {
		// remove spaces in the start and end
		str = str.trim();
		// if empty is left, then no conversion to be done
		if (str.length() == 0)
			return 0;
		// if first character is a letter, invalid number
		if (Character.isLetter(str.charAt(0)))
			return 0;

		int i = 0;
		// gets sign (first character)s
		char sign = '+'; // indicates positive
		if (str.charAt(0) == '-') {
			sign = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}

		int result = 0;
		boolean posOverflow = false;
		
		for (; i < str.length(); i++) {
			// if char found is not a digit, then stop and returns what we have
			if (!Character.isDigit(str.charAt(i)))
				break;

			// else we know we have a digit. because it's a char, subtracts 48 or '0' from current char
			int currentDigit = (int) (str.charAt(i) - 48);

			// check whether we'll overflow result and then break
			if (result > (Integer.MAX_VALUE) / 10 || ((result == (Integer.MAX_VALUE) / 10) && currentDigit > 7)) {
				posOverflow = true;
				break;
			}
			
			// multiply by ten and add current value
			result = result * 10 + currentDigit;
		}

		// check whether we overflowed result to return Integer.MAX_VALUE or Integer.MIN_VALUE
		if (posOverflow)
			return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		// else returns result
		return sign == '-' ? -result : result;
	}
}
