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
        if (root == null) return isValid;
        
        visit(root);
        isValidBST(root.left);
        isValidBST(root.right);

        return isValid;
    }

    public void visit(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        System.out.println(isValid);

        if (node.left != null && node.left.val >= node.val) isValid = false;
        if (node.right != null && node.right.val <= node.val) isValid = false;

        visit(node.left);
        visit(node.right);
    }
}
