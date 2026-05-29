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
            int candidate = 0;
            TreeNode curr = queue.poll();
            candidate = curr.val;
            max = Math.max(max, candidate);

            if (curr.left != null) {
                queue.add(curr.left);
                candidate = curr.val + curr.left.val;
                max = Math.max(max, candidate);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                candidate = curr.val + curr.right.val;
                max = Math.max(max, candidate);
            }

            if (curr.right != null && curr.left != null) {
                candidate = curr.val + curr.left.val + curr.right.val;
                max = Math.max(max, candidate);
            }
        }

        return max;
    }
}
