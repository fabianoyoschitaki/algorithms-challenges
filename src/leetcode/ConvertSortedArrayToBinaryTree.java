package leetcode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author fabiano
 *
 */
public class ConvertSortedArrayToBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        String numsStr = "[";
        for (int i : nums) {
            numsStr += i + ",";
        }
        numsStr += "]";
        System.out.println("Creating balanced BST for " + numsStr);
        return constructBSTRecursive(nums, 0, nums.length - 1, 0);
    }

    public TreeNode constructBSTRecursive(int[] nums, int left, int right, int level) {
        String spaces = "";
        for (int i = 0; i < level; i++) {
            spaces += "  ";
        }
        if (left > right) {
            System.out.println(spaces + "Left is bigger than right: " + left + " > " + right + ", returning null");
            return null;
        }

        int mid = left + (right - left) / 2;
        System.out.println(spaces + 
                "Mid for left [" + left + "] and right [" + right + "] is: " + mid + " with value " + nums[mid]);
        TreeNode node = new TreeNode(nums[mid]);
        System.out.println(spaces + "Created node (" + nums[mid] + ")");
        node.left = constructBSTRecursive(nums, left, mid - 1, level+1);
        node.right = constructBSTRecursive(nums, mid + 1, right, level+1);
        return node;
    }

    public static void main(String[] args) {
        new ConvertSortedArrayToBinaryTree().sortedArrayToBST(new int[] { -30, -20, -10, -3, 0, 5, 9, 10, 15, 18 });
    }
}
