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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // BST --> if p & q > root --> just see right side of tree
        // if p & q < root --> just see left side of tree
        // else return root
        if (p.val == root.val || q.val == root.val) return root;

        if (p.val > root.val && q.val > root.val) return search(root.right, p, q);
        else if (p.val < root.val && q.val < root.val) return search(root.left, p, q);

        return root;
    }

    public TreeNode search(TreeNode node, TreeNode p, TreeNode q) {
        if (p.val == node.val || q.val == node.val) return node;

        if (p.val > node.val && q.val > node.val) return search(node.right, p, q);
        else if (p.val < node.val && q.val < node.val) return search(node.left, p, q);

        return node;
    }
}
