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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return visit(root) && visit(root.left) && visit(root.right);
    }

    public boolean visit(TreeNode node) {
        if (node == null) return true;
        if (node.left != null) {
            if (node.left.val >= node.val) return false;
        }

        if (node.right != null) {
            if (node.right.val <= node.val) return false;
        }

        visit(node.left);
        visit(node.right);

        return true;
    }
}
