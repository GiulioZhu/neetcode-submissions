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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int highest = root.val;
        explore(root, highest);
        return count;
    }

    public void explore(TreeNode node, int ceil) {
        if (node == null) return;
        if (node.val >= ceil) count++;
        
        System.out.println(node.val);
        System.out.println(ceil);
        System.out.println(count);

        explore(node.left, ceil);
        explore(node.right, ceil);
    }
}
