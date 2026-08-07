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
    int preindex=0;
    int inindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildtree(preorder,inorder,Integer.MAX_VALUE);
    }
    public TreeNode buildtree(int[] preorder,int[] inorder,int limit){
        if(preindex>=preorder.length)
            return null;
        if(inorder[inindex]==limit){
            inindex++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[preindex++]);
        root.left=buildtree(preorder,inorder,root.val);
        root.right=buildtree(preorder,inorder,limit);
        return root;
    }
}
