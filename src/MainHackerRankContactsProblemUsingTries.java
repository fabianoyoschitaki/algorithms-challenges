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
		// TODO Auto-generated method stub

	}

}

class TrieNode {
	private static final int NUMBER_OF_CHARACTERS = 26;
	
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
	
	private void add(String s, int index) {
		
	}
	
	public int findCount(String s, int index) {
		
	}
	
}

