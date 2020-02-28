/**
 * Check if binary tree is also a binary search tree following:
 * https://www.youtube.com/watch?v=i_Q0v_Ct5lY&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=6
 * 
 * BST: all nodes on the left are smaller or equal than parent and all nodes on
 * the right are bigger or equal than parent.
 * 
 * This has a linear time solution O(n). Space complexity if O(log N) because of
 * its recursive nature.
 * 
 * @author fabiano
 *
 */
public class MainHackerRankIsThisBinaryTreeAlsoBinarySearchTree {
	public static void main(String[] args) {
		BinTNode root = new BinTNode(10);
		System.out.println(checkBinarySearchTree(root));

		root.left = new BinTNode(5);
		root.right = new BinTNode(20);
		System.out.println(checkBinarySearchTree(root));

		root.left.right = new BinTNode(8);
		root.left.left = new BinTNode(1);
		root.right.right = new BinTNode(30);
		root.right.left = new BinTNode(15);
		System.out.println(checkBinarySearchTree(root));

		root.right.left = new BinTNode(9);
		System.out.println(checkBinarySearchTree(root));
	}

	static boolean checkBinarySearchTree(BinTNode node) {
		return checkBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean checkBinarySearchTree(BinTNode node, int min, int max) {
		// base case
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		boolean isRightBST = checkBinarySearchTree(node.right, node.data + 1, max);
		boolean isLeftBST = checkBinarySearchTree(node.left, min, node.data - 1); // -1 because there are no duplicates
																					// in the tree
		return isRightBST && isLeftBST;
	}
}

class BinTNode {
	int data;
	BinTNode right;
	BinTNode left;

	public BinTNode(int data) {
		this.data = data;
	}
}
