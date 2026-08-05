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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return sum;
    }
    public int path(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,path(node.left));
        int right=Math.max(0,path(node.right));
        int curr=left+node.val+right;
        sum=Math.max(sum,curr);
        return node.val+Math.max(left,right);
    }
}
