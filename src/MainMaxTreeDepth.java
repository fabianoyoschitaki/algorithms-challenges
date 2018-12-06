

public class MainMaxTreeDepth {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(100);
//		tree.root.left = new TreeNode(50);
//		tree.root.right = new TreeNode(150);
//		tree.root.right.right = new TreeNode(200);
		System.out.println("Max depth tree:" + tree.maxDepth(tree.root));
	}
}
/**
 *                  (100)
 *                 /     \
 *              (50)    (150) 
 *                         \
 *                        (200)
 *  
 * 
 * @author F0113091
 *
 */
class BinaryTree {
	TreeNode root;
	public int maxDepth (TreeNode root){
		if (root == null){
			return -1; // or 0 if 1 node is 1 height
		}
		int rightDepth = maxDepth(root.right);
		System.out.println("(" + root.value + ") right is:" + rightDepth);
		int leftDepth = maxDepth(root.left);
		System.out.println("(" + root.value + ") left is:" + leftDepth);
		
		if (rightDepth > leftDepth){
			System.out.println("(" + root.value + ") returning right is bigger:" + (rightDepth+1));
			return rightDepth+1;
		} else {
			System.out.println("(" + root.value + ") returning left is bigger:" + (leftDepth+1));
			return leftDepth+1;
		}
	}
}

class TreeNode {
	TreeNode right;
	TreeNode left;
	int value;
	
	TreeNode(int value){
		this.value = value;
	}
}