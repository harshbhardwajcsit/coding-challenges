package com.practise.BinaryTree_problems;


import com.practise.BinaryTree_problems.common.BinaryTree;
import com.practise.BinaryTree_problems.common.Node;

public class DistanceBtwTwoRootAndNodeInBT {
    static int distance = 0;

    public static int getDistance(Node n1, Node n2) {
        if (n1.equals(n2)) {
            return distance;
        } else {
            distance = +distance;
            if (n1.left != null && n1.right != null) {
                getDistance(n1.left, n2);
                getDistance(n1.right, n2);
            } else if (n1.left != null && n1.right == null) {
                getDistance(n1.left, n2);
            } else if (n1.left == null && n1.right != null) {
                getDistance(n1.right, n2);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Node tree = BinaryTree.getBinaryTree();
        System.out.println(DistanceBtwTwoRootAndNodeInBT.getDistance(tree, new Node(57)));
    }
}
