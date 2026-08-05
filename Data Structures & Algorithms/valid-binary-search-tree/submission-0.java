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
    boolean isbst=true;
    int lag=Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isbst;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(root.val>lag){
            lag=root.val;
        }
        else{
            isbst=false;
        }
        inorder(root.right);
    }
}
