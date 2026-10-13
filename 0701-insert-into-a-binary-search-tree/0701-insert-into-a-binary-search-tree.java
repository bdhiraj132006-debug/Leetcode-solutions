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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null)
        {
            return newNode;
        }

        TreeNode current = root;
        while(true)
        {
            if(val < current.val)
            {
                if(current.left == null)
                {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            }
            else
            {
                if(current.right == null)
                {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }
}