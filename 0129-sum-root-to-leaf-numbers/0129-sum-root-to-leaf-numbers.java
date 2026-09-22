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
    static int solve(int num,TreeNode root){
        if(root==null){
            return 0;
        }
        num = num * 10+root.val;

        if(root.left==null && root.right==null){
            return num;
        }
        return solve(num,root.left)+solve(num,root.right);

    }
    public int sumNumbers(TreeNode root) {
        int num = 0;
        return solve(num,root);
        
        
    }
}