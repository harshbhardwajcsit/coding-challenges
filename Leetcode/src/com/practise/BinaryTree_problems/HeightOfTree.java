package com.practise.BinaryTree_problems;

import com.practise.BinaryTree_problems.common.Node;

/*
----Recursive approach----
Height of any node will be Maximum height of its left subtree or right subtree + 1
considering height of null nodes is 0.

---similar problems---
1. Longest path sum to the leaf same as the max depth or height
2. Nodes in the longest path same as Height + 1
 */
public class HeightOfTree {
    static int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
    }
}
