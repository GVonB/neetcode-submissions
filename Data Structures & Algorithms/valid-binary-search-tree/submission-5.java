/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
    Conditions for a valid BST:
    1. The left subtree of any node contains only nodes with
        values less than the node's value.
    2. Vice-verse for right nodes.
    3. Both the left and right subtrees are also BSTs -- RECURSION
    
    Approach:
    if (node.left == null && node.right == null) return true;
    if (node.left == null && node.val < node.right.val) return isValidBST(node.right);
    if (node.right == null && node.val > node.left.val) return isValidBST(node.left);

    1. check if (node.left.val > node.val || node.right.val < node.val) return false;
    call recursive function
    */
    public boolean isValidBST(TreeNode node) {
        return valid(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean valid(TreeNode node, int left, int right) {
        if (node == null) return true;
        if (left >= node.val || node.val >= right) return false;
        return valid(node.left, left, node.val) &&
               valid(node.right, node.val, right);
    }
}
