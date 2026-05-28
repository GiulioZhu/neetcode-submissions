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
    List<Integer> sorted = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        search(root);
        return sorted.get(k-1);
    }

    public void search(TreeNode node) {
        if (node == null) return;

        search(node.left);
        sorted.add(node.val);
        search(node.right);
        
    }
}
