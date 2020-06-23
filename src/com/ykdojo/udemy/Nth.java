package com.ykdojo.udemy;

import java.util.HashMap;

public class Nth {
    public static void main(String[] args) {
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;
        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

        System.out.println(nthFromLast(head, 1)); // should return 1.
        System.out.println(nthFromLast(head, 5)); //  should return 5.
        System.out.println(nthFromLast(head, 7)); //  should return 7.
        System.out.println(nthFromLast(head, 8)); //  should return null.
        
        System.out.println(nthFromLast(head2, 2)); //  should return 3.
        System.out.println(nthFromLast(head2, 4)); //  should return 1.
        System.out.println(nthFromLast(head2, 5)); //  should return null.
        
        System.out.println(nthFromLast(null, 1)); //  should return null.
    }


    // Implement your function below.
    public static Node nthFromLast2(Node head, int n) {
        int pos = 0;
        Node current = head;
        if (current == null){
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        while (current != null){
            map.put(pos, current); // 0,7; 1,6; ... 6,1;
            pos++;
            current = current.child;
        }
        if (n > map.size()){
            return null;
        }
        return map.get(map.size()-n); // n = 7, 
    }

    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        if (head == null){ // unnecessary because of first if inside for loop
            return null;
        }
        Node left = head;
        Node right = head;
        for (int i = 0; i < n; i++){
            if (right == null){
                return null;
            }
            right = right.child;
        }
        while (right != null){
            right = right.child;
            left = left.child;
        }
        return left;
    }


    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
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

 class Node {
        int value;
        Node child;

        public Node(int value, Node child){
            this.value = value;
            this.child = child;
        }

        public String toString(){
            return "" + value;
        }
    }
