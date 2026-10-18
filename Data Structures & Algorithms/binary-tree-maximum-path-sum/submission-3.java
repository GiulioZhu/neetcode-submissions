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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int left = dfs(node.left);
        int right = dfs(node.right);
        int best = Math.max(node.val + Math.max(left + right, Math.max(left, right)), node.val);
        System.out.println(best);
        if (best > max) max = best;
        return best;
    }
}
