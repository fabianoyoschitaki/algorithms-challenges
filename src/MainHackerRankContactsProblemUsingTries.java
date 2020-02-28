/**
 * Trie: https://en.wikipedia.org/wiki/Trie a.k.a. Digital Tree or Prefix Tree. 
 *
 * Solve List of Contacts problem using tries following
 * https://www.youtube.com/watch?v=vlYZb68kAY0&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=8
 * 
 * Implement a very simple contact list. This list must have 2 things: - Add
 * things to it - Given a string, how many contacts start with that string
 * 
 * One way to do this is to store it in a giant list, maybe a sorted list and
 * walk through and check which contact starts with that string, but that's
 * pretty inefficient. This is the problem where a Trie is perfect for. We just
 * need to build a trie for ourselves. When receive a string, just walk through
 * that trie and ask: how many child do you have?
 * 
 * One little optimization is when we get some substring, find that node and
 * then walk through all of its children and count how many there are. But even
 * easier is just count, let each node in the trie store how many children it
 * has. That's a very easy thing to keep track and will make our code more
 * efficient, also shorter to write. 
 * 
 * @author fabiano
 *
 */
public class MainHackerRankContactsProblemUsingTries {

	public static void main(String[] args) {
		TrieNode root = new TrieNode("");
		root.add("fabiano");
		root.add("fabio");
		root.add("fabia");
		root.add("facil");
		root.add("faca");
		root.add("foi");
		root.add("a");
		root.add("ab");
		root.findCount("");
		root.findCount("a");
		root.findCount("ab");
		root.findCount("fab");
		root.findCount("fa");
		root.findCount("fabx");
	}
}

class TrieNode {
	
	public TrieNode(String me) {
		this.me = me;
	}
	private static final int NUMBER_OF_CHARACTERS = 26;
	String me;
	int size = 0;
	
	// children will be null if there's no contact after it
	private TrieNode [] children = new TrieNode[NUMBER_OF_CHARACTERS];
	
	private static int getCharIndex(char c) {
		return c - 'a';
	}
	private TrieNode getNode(char c) {
		return children[getCharIndex(c)];
	}
	
	private void setNode(char c, TrieNode node) {
		children[getCharIndex(c)] = node;
	}
	
	public void add(String s) {
		System.out.println("Added: " + s);
		add(s, 0);
	}
	
	/**
	 * Recursive adding chars in the trie
	 * 
	 * @param s
	 * @param index
	 */
	private void add(String s, int index) {
		size++;
		if (index == s.length()) 
			return;
		char current = s.charAt(index);
		TrieNode child = getNode(current);
		if (child == null) {
			child = new TrieNode(String.valueOf(current));
			setNode(current, child);
		}
		child.add(s, index+1);
	}
	
	/**
	 * Returns number of elements that starts with string
	 * 
	 * @param s
	 * @param index
	 * @return
	 */
	public void findCount(String s) {
		System.out.println("FindCount for: " + s + " is " + findCount(s, 0));
	}
	
	private int findCount(String s, int index) {
		if (index == s.length()) {
			return size;
		}
		char current = s.charAt(index);
		TrieNode child = getNode(current);
		if (child == null) {
			return 0;
		}
		return child.findCount(s, index+1);
	}
}

