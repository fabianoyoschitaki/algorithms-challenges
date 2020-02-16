
public class MainReverseWordsInAString {
	
	static String PHRASE = "I work at BairesDev"; 
	public static void main(String[] args) {
		System.out.println(PHRASE);
		System.out.println(reverseWords(PHRASE));
	}
	
	public static String reverseWords(final String phrase) {
		String [] str = phrase.split(" ");
		String answer = "";
		for (int i = str.length-1; i >= 0; i--) {
			answer += str[i] + " ";
		}
		return answer;
	}
}
