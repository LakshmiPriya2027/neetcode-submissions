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
    List<Integer>inorder=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        int ans;
        traverse(root);
        ans=inorder.get(k-1);
        return ans;
    }
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
        inorder.add(root.val);
        traverse(root.right);
    }
}
