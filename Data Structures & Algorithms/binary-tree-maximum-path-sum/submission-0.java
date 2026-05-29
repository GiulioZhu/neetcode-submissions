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
    Queue<TreeNode> queue = new LinkedList<>();
    public int maxPathSum(TreeNode root) {
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while(queue.peek() != null) {
            int sum = 0;
            TreeNode curr = queue.poll();
            sum += curr.val;

            if (curr.left != null) {
                queue.add(curr.left);
                sum += curr.left.val;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                sum += curr.right.val;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
