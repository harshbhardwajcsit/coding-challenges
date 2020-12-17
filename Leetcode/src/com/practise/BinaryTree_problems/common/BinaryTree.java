package com.practise.BinaryTree_problems.common;

/*
 Distance between Two node = Distance[Root, Node 1] + Distance[Root, Node 2] - 2*Distance[Root, LCA(Node 1, Node 2)]
*/
public class BinaryTree {
    public static Node root = null;

    public static void createNewTree() {
        root = new Node(50);
        root.left = new Node(51);
        root.right = new Node(52);
        root.left.left = new Node(53);
        root.left.right = new Node(54);
        root.right.left = new Node(55);
        root.right.right = new Node(56);
        root.right.right.right = new Node(58);
        root.right.right.left = new Node(57);
        root.left.left.left = new Node(60);
    }

    public static Node getBinaryTree(){
        return root;
    }

    public static void insert(Node node, int value) {
//        if (value < node.value) {
//            if (node.left != null) {
//                insert(node.left, value);
//            } else {
//                node.left = new Node(value);
//            }
//        } else if (value > node.value) {
//            if (node.right != null) {
//                insert(node.right, value);
//            } else {
//                node.right = new Node(value);
//            }
//        }


    }
}
