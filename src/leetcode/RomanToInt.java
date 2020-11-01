package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author fabiano
 *
 */
public class RomanToInt {
    static Map<Character, Integer> ROMAN_TO_INT = new HashMap<Character, Integer>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};
    
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty())
            return 0;
        
        int result = 0;
        int lastValue = 0;
        
        for (int i = s.length()-1; i >= 0; i--) {
            int currentValue = ROMAN_TO_INT.get(s.charAt(i));
            if (currentValue >= lastValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            lastValue = currentValue;
        }
        return result;
        
    }
    
    public static void main(String[] args) {
        assert romanToInt("III") == 3;
        assert romanToInt("IV") == 4;
        assert romanToInt("IX") == 9;
        assert romanToInt("LVIII") == 58;
        assert romanToInt("MCMXCIV") == 1994;
    }
}
