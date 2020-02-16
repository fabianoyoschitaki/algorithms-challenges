import java.util.HashMap;

public class MainIsThisABinarySearchTree {
	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your solution.
		// The mapping we're going to use for constructing a tree.
		// For example, {0: [1, 2]} means that 0's left child is 1, and its right
		// child is 2.
		HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
		int[] childrenA = { 1, 2 };
		int[] childrenB = { 3, 4 };
		int[] childrenC = { 5, 6 };
		mapping1.put(0, childrenA);
		mapping1.put(1, childrenB);
		mapping1.put(2, childrenC);

		BTreeNode head1 = createTree(mapping1, 0);
		// This tree is:
		// head1 = 0
		// / \
		// 1 2
		// /\ /\
		// 3 4 5 6

		HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
		int[] childrenD = { 1, 4 };
		int[] childrenE = { 0, 2 };
		int[] childrenF = { 5, 6 };
		mapping2.put(3, childrenD);
		mapping2.put(1, childrenE);
		mapping2.put(4, childrenF);

		BTreeNode head2 = createTree(mapping2, 3);
		// This tree is:
		// head2 = 3
		// / \
		// 1 4
		// /\ / \
		// 0 2 5 6

		HashMap<Integer, int[]> mapping3 = new HashMap<Integer, int[]>();
		int[] childrenG = { 1, 5 };
		int[] childrenH = { 0, 2 };
		int[] childrenI = { 4, 6 };
		mapping3.put(3, childrenG);
		mapping3.put(1, childrenH);
		mapping3.put(5, childrenI);

		BTreeNode head3 = createTree(mapping3, 3);
		// This tree is:
		// head3 = 3
		// / \
		// 1 5
		// /\ / \
		// 0 2 4 6

		HashMap<Integer, int[]> mapping4 = new HashMap<Integer, int[]>();
		int[] childrenJ = { 1, 5 };
		int[] childrenK = { 0, 4 };
		mapping4.put(3, childrenJ);
		mapping4.put(1, childrenK);

		BTreeNode head4 = createTree(mapping4, 3);
		// This tree is:
		// head4 = 3
		// / \
		// 1 5
		// /\
		// 0 4

		// System.out.println("should return false:" + isBST(head1)); // should return
		// false
		// System.out.println("should return false:" + isBST(head2)); // should return
		// false
		System.out.println("should return true:" + isBST(head3)); // should return true
		// System.out.println("should return false:" + isBST(head4)); // should return
		// false
	}

	// Implement your function below.
	public static boolean isBST(BTreeNode node) {
		return isBSTRecursive(node, null, null);
	}

	public static boolean isBSTRecursive(BTreeNode node, Integer lowerLimit, Integer upperLimit) {
		System.out.println("node[" + node.value + "] lowerLimit[" + lowerLimit + "] upperLimit[" + upperLimit + "]");
		if (lowerLimit != null && node.value < lowerLimit) {
			System.out
					.println("node[" + node.value + "] IS LESS THAN lowerLimit[" + lowerLimit + "], returning false!");
			return false;
		}
		if (upperLimit != null && node.value > upperLimit) {
			System.out.println(
					"node[" + node.value + "] IS GREATER THAN upperLimit[" + lowerLimit + "], returning false!");
			return false;
		}
		boolean isRightBST = true;
		boolean isLeftBST = true;
		if (node.right != null) {
			System.out.println("node[" + node.value + "] has right child node[" + node.right.value + "]");
			isRightBST = isBSTRecursive(node.right, node.value, upperLimit);
		}
		if (node.left != null) {
			System.out.println("node[" + node.value + "] has left child node[" + node.left.value + "]");
			isLeftBST = isBSTRecursive(node.left, lowerLimit, node.value);
		}
		System.out.println("returning " + isRightBST + " && " + isLeftBST);
		return isRightBST && isLeftBST;
	}

	// A function for creating a tree.
	// Input:
	// - mapping: a node-to-node mapping that shows how the tree should be
	// constructed
	// - headValue: the value that will be used for the head ndoe
	// Output:
	// - The head node of the resulting tree
	public static BTreeNode createTree(HashMap<Integer, int[]> mapping, int headValue) {
		BTreeNode head = new BTreeNode(headValue, null, null);
		HashMap<Integer, BTreeNode> nodes = new HashMap<Integer, BTreeNode>();
		nodes.put(headValue, head);
		for (Integer key : mapping.keySet()) {
			int[] value = mapping.get(key);
			BTreeNode leftChild = new BTreeNode(value[0], null, null);
			BTreeNode rightChild = new BTreeNode(value[1], null, null);
			nodes.put(value[0], leftChild);
			nodes.put(value[1], rightChild);
		}
		for (Integer key : mapping.keySet()) {
			int[] value = mapping.get(key);
			nodes.get(key).left = nodes.get(value[0]);
			nodes.get(key).right = nodes.get(value[1]);
		}
		return head;
	}
}

class BTreeNode {
	int value;
	BTreeNode left;
	BTreeNode right;

	public BTreeNode(int value, BTreeNode left, BTreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
