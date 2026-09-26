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
    static TreeNode prev;
    static TreeNode swap1;
    static TreeNode swap2;
    static boolean solve(TreeNode root){

        if(root==null){
            return true;
        }

        if(!solve(root.left)){
            return false;
        }

        if(prev!=null && prev.val>root.val){
            if(swap1==null){
                swap1 = prev;
            }
            swap2 = root;
        }
        prev = root;

        return solve(root.right);
    }
    public void recoverTree(TreeNode root) {
        prev = null;
        swap1 = null;
        swap2 = null;
        solve(root);

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }
}