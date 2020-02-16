import java.util.HashMap;

public class MainFindNthElementFromEndAtLinkedList {
	public static void main(String[] args) {
		NodeNth current = new NodeNth(1, null);
		for (int i = 2; i < 8; i++) {
			current = new NodeNth(i, current);
		}
		NodeNth head = current;
		// head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

		NodeNth current2 = new NodeNth(4, null);
		for (int i = 3; i > 0; i--) {
			current2 = new NodeNth(i, current2);
		}
		NodeNth head2 = current2;
		// head2 = 1 -> 2 -> 3 -> 4 -> (null)

		System.out.println(nthFromLast(head, 1)); // should return 1.
		System.out.println(nthFromLast(head, 5)); // should return 5.
		System.out.println(nthFromLast(head, 7)); // should return 7.
		System.out.println(nthFromLast(head, 8)); // should return null.

		System.out.println(nthFromLast(head2, 2)); // should return 3.
		System.out.println(nthFromLast(head2, 4)); // should return 1.
		System.out.println(nthFromLast(head2, 5)); // should return null.

		System.out.println(nthFromLast(null, 1)); // should return null.
	}

	// Implement your function below.
	public static NodeNth nthFromLast2(NodeNth head, int n) {
		int pos = 0;
		NodeNth current = head;
		if (current == null) {
			return null;
		}
		HashMap<Integer, NodeNth> map = new HashMap<>();
		while (current != null) {
			map.put(pos, current); // 0,7; 1,6; ... 6,1;
			pos++;
			current = current.child;
		}
		if (n > map.size()) {
			return null;
		}
		return map.get(map.size() - n); // n = 7,
	}

	// Implement your function below.
	public static NodeNth nthFromLast(NodeNth head, int n) {
		if (head == null) {
			return null;
		}
		NodeNth left = head;
		NodeNth right = head;
		for (int i = 0; i < n; i++) {
			if (right == null) {
				return null;
			}
			right = right.child;
		}
		while (right != null) {
			right = right.child;
			left = left.child;
		}
		return left;
	}

	// NOTE: Feel free to use the following function for testing.
	// It converts the given linked list into an easy-to-read string format.
	// Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
	public static String linkedListToString(NodeNth head) {
		NodeNth current = head;
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append(String.valueOf(current.value));
			sb.append(" -> ");
			current = current.child;
		}
		sb.append("(null)");
		return sb.toString();
	}
}

class NodeNth {
	int value;
	NodeNth child;

	public NodeNth(int value, NodeNth child) {
		this.value = value;
		this.child = child;
	}

	public String toString() {
		return "" + value;
	}
}
