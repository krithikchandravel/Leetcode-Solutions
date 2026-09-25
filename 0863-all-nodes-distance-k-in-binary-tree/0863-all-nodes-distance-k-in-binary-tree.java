/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static Map<Integer,Integer> map;
    static int BFS(TreeNode root){
        int max = 0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            
            if(temp.left!=null){
                max = Math.max(max,temp.left.val);
                map.put(temp.left.val,temp.val);
                q.offer(temp.left);
            }
            if(temp.right!=null){
                max = Math.max(max,temp.right.val);
                map.put(temp.right.val,temp.val);
                q.offer(temp.right);
            }
        }
        return max;
    }
    static void Dfs(List<List<Integer>> adj,int node,boolean[] seen,int count,int k,List<Integer> curr){
        seen[node] = true;
        if(count==k){
            curr.add(node);
        }
        for(int nei : adj.get(node)){
            if(!seen[nei]){
                Dfs(adj,nei,seen,count+1,k,curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<>();
        map = new HashMap<>();
        int max = BFS(root);
        if(max<=1) return new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=max;i++){
            adj.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             int u = entry.getKey();
             int v = entry.getValue();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] seen = new boolean[max+1];
        List<Integer> result = new ArrayList<>();
        Dfs(adj,target.val,seen,0,k,result);
        return result;

    }
}