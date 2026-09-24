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
    static Map<Integer,int[]> map;
    static void Cousins(TreeNode root){
       if(root==null){
           return;
       }
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       int level = 0;
       while(!q.isEmpty()){
           int s = q.size();
           for(int i=0;i<s;i++){

               TreeNode curr = q.poll();
               
               if(curr.left!=null){
                   map.put(curr.left.val,new int[] {curr.val,level});
                   q.offer(curr.left);
               }
               if(curr.right!=null){
                   map.put(curr.right.val,new int[] {curr.val,level});
                   q.offer(curr.right);
               }
           }
           level++;
       }
   }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        map = new HashMap<>();
        Cousins(root);
        int[] data1 = map.get(x);
        int[] data2 = map.get(y);

        if(data1==null || data2==null) return false;
        
        return data1[0]!=data2[0] && data1[1]==data2[1];
    }
}