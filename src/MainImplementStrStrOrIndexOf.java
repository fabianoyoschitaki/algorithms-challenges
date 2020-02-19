/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author fabiano
 *
 */
public class MainImplementStrStrOrIndexOf {
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}
	
	public static int strStr(String haystack, String needle) {
		if (needle.equals(""))
			return 0;
        int ans = -1;
        for (int i = 0; i < haystack.length()+1-needle.length(); i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                ans = i;
            	int tempI = i+1;
                int tempK = 1;
                while (tempK < needle.length()){
                    if (haystack.charAt(tempI) == needle.charAt(tempK)){
                        tempI++;
                        tempK++;
                    } else {
                        ans = -1;
                        break;
                    }
                }
                if (ans != -1)
                    return ans;
            }
        }
        return ans;
    }
}
