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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.peek() != null) {
            TreeNode curr = new TreeNode();
            List<Integer> tmp = new ArrayList<>();

            while(queue.peek() != null) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                    tmp.add(curr.left.val);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    tmp.add(curr.right.val);
                }

            }
            if (tmp.size() > 0) res.add(tmp.get(tmp.size() - 1));
            queue.add(queue.poll());
            
        }
        return res;
    }
}
