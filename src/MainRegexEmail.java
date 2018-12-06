import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author F0113091
 *
 */
public class MainRegexEmail {

	static final String regularExp = "[a-z]{1,6}_?[0-9]{0,4}@hackerrank\\.com";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> email = Arrays.asList(
			"abcdef_1234@hackerrank.com",
			"a1@hackerrank.com",
			"a_1@hackerrank.com",
			"a__1@hackerrank.com",
			"abcdef1234@hackerrank.com");
		
		for (String e : email) {
			if (e.matches(regularExp)){
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}

}
