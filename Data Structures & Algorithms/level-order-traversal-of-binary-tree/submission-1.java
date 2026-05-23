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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> pq = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        pq.addLast(root);
        pq.addLast(null);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        while (pq.peek() != null) {
            List<Integer> level = new ArrayList<>();
            while(pq.peek() != null) {
                TreeNode node = pq.poll();                
                if (node.left != null) pq.addLast(node.left);
                if (node.right != null) pq.addLast(node.right);
                level.add(node.val);
            }
            pq.add(pq.poll());
            ans.add(level);
        }
        return ans;
    }
}
