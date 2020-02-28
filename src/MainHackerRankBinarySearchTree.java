
/**
 * Implement Binary Search Tree following:
 * https://www.youtube.com/watch?v=oSWTXtMglKE
 * 
 * @author fabiano
 */
public class MainHackerRankBinarySearchTree {
	public static void main(String[] args) {
		NodeBST root = new NodeBST(10);
		root.insert(5);
		root.insert(15);
		root.insert(8);
		root.insert(3);
		root.insert(4);
		root.insert(1);
		root.insert(90);
		root.insert(12);
		root.insert(13);
		root.insert(80);
		root.insert(100);
		System.out.println("In Order");
		root.printInOrder();

		System.out.println("\nPre Order");
		root.printPreOrder();

		System.out.println("\nPost Order");
		root.printPostOrder();
	}
}

class NodeBST {
	int data;
	NodeBST right;
	NodeBST left;

	public NodeBST(int data) {
		this.data = data;
	}

	public void insert(int value) {
		// if it's less or equal, then put to the left
		if (value <= this.data) {
			// if we still don't have a left child, then put it directly
			if (this.left == null) {
				this.left = new NodeBST(value);
			}
			// else let's run the recursion
			else {
				this.left.insert(value);
			}
		} else { // it's bigger than data
			if (this.right == null) {
				this.right = new NodeBST(value);
			} else {
				this.right.insert(value);
			}
		}
	}

	public boolean contains(int value) {
		if (value == this.data) {
			return true;
		}
		if (value < this.data) {
			if (this.left == null) {
				return false;
			} else {
				return this.left.contains(value);
			}
		} else {
			if (this.right == null) {
				return false;
			} else {
				return this.right.contains(value);
			}
		}
	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.print("[" + this.data + "]");
		if (right != null) {
			right.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.print("[" + this.data + "]");
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}

	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.print("[" + this.data + "]");
	}
}