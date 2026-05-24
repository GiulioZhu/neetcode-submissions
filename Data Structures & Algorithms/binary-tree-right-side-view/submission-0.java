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
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return ans;
        ans.add(root.val);

        queue.add(root);
        queue.add(null);

        while(queue.peek() != null) {
            List<Integer> tmp = new ArrayList<>();
            while(queue.peek() != null) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    tmp.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    tmp.add(node.right.val);
                }
            }
            if (tmp.size() > 0) ans.add( tmp.get( tmp.size() - 1 )  );
            queue.add(queue.poll());
        }

        return ans;
    }
}
 