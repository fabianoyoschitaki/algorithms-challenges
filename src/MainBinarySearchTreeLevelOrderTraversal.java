import java.util.LinkedList;
import java.util.Queue;



public class MainBinarySearchTreeLevelOrderTraversal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new BSTNode(3);
		tree.root.left = new BSTNode(2);
		tree.root.left.left = new BSTNode(1);
		tree.root.right = new BSTNode(5);
		tree.root.right.left = new BSTNode(4);
		tree.root.right.left.right = new BSTNode(6);
		tree.root.right.left.right.left = new BSTNode(11);
		tree.root.right.left.right.left.left = new BSTNode(13);
		tree.root.right.left.right.left.right = new BSTNode(16);
		tree.root.right.left.right.right = new BSTNode(12);
		tree.root.right.right = new BSTNode(7);
		tree.root.right.right.right = new BSTNode(10);
		tree.levelOrder(tree.root);
	}
}

/**
 *                  ( 3 )
 *                 /     \
 *              ( 2 )   ( 5 ) 
 *               /      /   \
 *            ( 1 )  ( 4 ) ( 7 )
 *                      \     \
 *                     ( 6 ) ( 10 ) 
 *                     /   \
 *                   (11)  (12)
 *                   /  \
 *                 (13) (16)     
 * Answer should be 3 2 5 1 4 7 6 10 11 12 13 16
 *
 */
class BinarySearchTree {
	BSTNode root;
	void levelOrder(BSTNode root){
		if (root != null){
			Queue<BSTNode> q = new LinkedList<BSTNode>();
			q.add(root);
			while (!q.isEmpty()){
				BSTNode head = q.poll();
				System.out.print(head.data + " ");
				if (head.left != null){
					q.add(head.left);
				}
				if (head.right != null){
					q.add(head.right);
				}
			}
		}
    }
}

class BSTNode{
	BSTNode left,right;
    int data;
    BSTNode(int data){
        this.data=data;
        left=right=null;
    }
}