/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (contains(root, p) && contains(root, q)) {
            
            ans = root;
        }
        lowestCommonAncestor(root.left, p, q);
        lowestCommonAncestor(root.right, p, q);
        return ans;
    }

    public Boolean contains(TreeNode node, TreeNode target) {
        if (node == null) return false;
        if (node.val == target.val) return true;
        return contains(node.left, target) || contains(node.right, target);

    }
}