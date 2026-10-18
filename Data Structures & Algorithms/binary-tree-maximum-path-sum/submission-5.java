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
    int max = -1001;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null) return 0;
        int left = maxPath(node.left);
        int right = maxPath(node.right);
        int best = node.val + Math.max(left, right);
        
        if (best > max) max = best;
        return Math.max(0, best);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        int left = maxPath(root.left);
        int right = maxPath(root.right);

        max = Math.max(max, root.val + left + right);
        dfs(root.left);
        dfs(root.right);
    }
}
