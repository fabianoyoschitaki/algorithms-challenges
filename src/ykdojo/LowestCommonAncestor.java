package ykdojo;

import java.util.HashMap;
import java.util.Stack;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // The mapping we're going to use for constructing a tree.
        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
        // child is 2.
        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
        int[] childrenA = {1, 2};
        int[] childrenB = {3, 4};
        int[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        TreeNodeLCA head1 = createTree(mapping1, 0);

        // This tree is:
        // head1 = 0
        //        / \
        //       1   2
        //      /\   /\
        //     3  4 5  6


        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
        int[] childrenD = {1, 4};
        int[] childrenE = {3, 8};
        int[] childrenF = {9, 2};
        int[] childrenG = {6, 7};
        mapping2.put(5, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);
        mapping2.put(3, childrenG);

        TreeNodeLCA head2 = createTree(mapping2, 5);
        // This tree is:
        //  head2 = 5
        //        /   \
        //       1     4
        //      /\    / \
        //     3  8  9  2
        //    /\
        //   6  7


        System.out.println(lca(head1, 1, 5)); // should return 0
        System.out.println(lca(head1, 3, 1)); // should return 1
        System.out.println(lca(head1, 1, 4)); // should return 1
        System.out.println(lca(head1, 0, 5)); // should return 0
        System.out.println(lca(head2, 4, 7)); // should return 5
        System.out.println(lca(head2, 3, 3)); // should return 3
        System.out.println(lca(head2, 8, 7)); // should return 1
        System.out.println(lca(head2, 3, 0)); // should return null (0 does not exist in the tree)
    }

    public static Stack<TreeNodeLCA> pathToValue(TreeNodeLCA node, int value){
        if (node == null){
            return null;
        }
        if (node.value == value){
            Stack<TreeNodeLCA> path = new Stack<>();
            path.push(node);
            return path;
        }

        if (node.left != null){
            Stack<TreeNodeLCA> leftPath = pathToValue(node.left, value);
            if (leftPath != null){
                leftPath.push(node);
                return leftPath;
            }
        }

        if (node.right != null){
            Stack<TreeNodeLCA> rightPath = pathToValue(node.right, value);
            if (rightPath != null){
                rightPath.push(node);
                return rightPath;
            }
        }
        return null;
    }



    // Implement your function below.
    public static TreeNodeLCA lca(TreeNodeLCA root, int j, int k) {
        Stack<TreeNodeLCA> pathToJ = pathToValue(root, j);
        Stack<TreeNodeLCA> pathToK = pathToValue(root, k);

        if (pathToJ == null || pathToK == null){
            return null;
        }
        TreeNodeLCA lca = null;
        while (!pathToJ.isEmpty() && !pathToK.isEmpty()){
            TreeNodeLCA jPop = pathToJ.pop();
            TreeNodeLCA kPop = pathToK.pop();
            if (jPop == kPop){
                lca = jPop;
            } else {
                break;
            }
        }
        return lca;
    }


    // A function for creating a tree.
    // Input:
    // - mapping: a node-to-node mapping that shows how the tree should be constructed
    // - headValue: the value that will be used for the head ndoe
    // Output:
    // - The head node of the resulting tree
    public static TreeNodeLCA createTree(HashMap<Integer, int[]> mapping, int headValue) {
        TreeNodeLCA head = new TreeNodeLCA(headValue, null, null);
        HashMap<Integer, TreeNodeLCA> nodes = new HashMap<Integer, TreeNodeLCA>();
        nodes.put(headValue, head);
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            TreeNodeLCA leftChild = new TreeNodeLCA(value[0], null, null);
            TreeNodeLCA rightChild = new TreeNodeLCA(value[1], null, null);
            nodes.put(value[0], leftChild);
            nodes.put(value[1], rightChild);
        }
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            nodes.get(key).left = nodes.get(value[0]);
            nodes.get(key).right = nodes.get(value[1]);
        }
        return head;
    }
 }

 class TreeNodeLCA {
    int value;
    TreeNodeLCA left;
    TreeNodeLCA right;

    public TreeNodeLCA(int value, TreeNodeLCA left, TreeNodeLCA right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "" + value;
    }
 }
