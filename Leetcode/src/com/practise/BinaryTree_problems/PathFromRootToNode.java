package com.practise.BinaryTree_problems;

import com.practise.BinaryTree_problems.common.BinaryTree;
import com.practise.BinaryTree_problems.common.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Recursive approach
step - 1 : if root is null, then no path can exists
step - 2 : add Node to the list
step - 3 : if Node value is same the x, then return true
step - 4 : else try to check in z exists in either of the left or right subtree of a current node
           if found, then return false
step - 5 : if not found, then remove that current node from the list.
 */

public class PathFromRootToNode {
    public static boolean hasPath(Node root, ArrayList<Integer> arr, int x) {
        if (root == null)
            return false;

        arr.add(root.value);


        if (root.value == x)
            return true;


        if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x))
            return true;


        arr.remove(arr.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node tree = BinaryTree.getBinaryTree();
        final List list = Collections.EMPTY_LIST;
        if (hasPath(tree, (ArrayList<Integer>) list, 53)) {
            System.out.println("path from root to node" + list);
        } else {
            System.out.println("no path found");
        }
    }
}
