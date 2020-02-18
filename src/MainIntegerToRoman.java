/**
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given an integer, convert it to a roman
 * numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author fabiano
 *
 */
public class MainIntegerToRoman {
	public static void main(String[] args) {
		System.out.println(intToRoman(3)); // III
		System.out.println(intToRoman(4)); // IV
		System.out.println(intToRoman(9)); // IX
		System.out.println(intToRoman(58)); // LVIII
		System.out.println(intToRoman(1994)); // MCMXCIV
		System.out.println(intToRoman(3999)); // MMMCMXCIX
	}

	private static String intToRoman(int value) {
		int [] values =   {1000, 900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
		String [] roman = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < values.length; i++) {
			while (value >= values[i]) {
				sb.append(roman[i]);
				value -= values[i];
			}
		}
		return sb.toString();
	}
	
	private static String intToRomanUgly(int value) {
		String result = "";
		if (value/1000 > 0) {
			for (int i = 0; i < value/1000; i++) {
				result = result + "M";
			}
			value = value % 1000;
		}
		if (value >= 900) {
			result = result + "CM";
			value = value % 900;
		} else if (value >= 500) {
			result = result + "D";
			value = value % 500;
		}
		
		if (value >= 400) {
			result = result + "CD";
			value = value % 400;
		} else if (value >= 100) {
			for (int i = 0; i < value/100; i++) {
				result = result + "C";
			}
			value = value % 100;
		}
		if (value >= 90) {
			result = result + "XC";
			value = value % 90;
		} else if (value >= 50) {
			result = result + "L";
			value = value % 50;
		}
		if (value >= 40) {
			result = result + "XL";
			value = value % 40;
		} else if (value >= 10) {
			for (int i = 0; i < value/10; i++) {
				result = result + "X";
			}
			value = value % 10;
		}
		if (value == 9) {
			result = result + "IX";
			value = value % 9;
		} else if (value >= 5) {
			result = result + "V";
			value = value % 5;
		}
		if (value == 4) {
			result = result + "IV";
		} else if (value >= 1) {
			for (int i = 0; i < value; i++) {
				result = result + "I";
			}
		}
		return result;
	}
}
