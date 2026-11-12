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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> rightside = new ArrayList<>();

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode node = new TreeNode();
            while(queue.peek() != null) {
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right!= null) queue.add(node.right);
            }
            rightside.add(node.val);

            queue.poll();
            if (!queue.isEmpty()) queue.add(null);
        }
        return rightside;
    }
}
