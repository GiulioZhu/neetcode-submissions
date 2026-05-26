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

    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        visit(root);

        return isValid;
    }

    public void visit(TreeNode node) {
        if (node == null) return;

        if (node.left != null && node.left.val >= node.val) isValid = false;
        if (node.right != null && node.right.val <= node.val) isValid = false;

        visit(node.left);
        visit(node.right);
    }
}
