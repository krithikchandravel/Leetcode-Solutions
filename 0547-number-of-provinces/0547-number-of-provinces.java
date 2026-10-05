class Solution {
    static void dfs(int node,int[][] grid,boolean[] seen){
        seen[node] = true;

        for(int i=0;i<grid.length;i++){
            if(!seen[i] && grid[node][i]==1){
                dfs(i,grid,seen);
            }
        }
    }
    public int findCircleNum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[] seen = new boolean[r];
        int count = 0;

        for(int i=0;i<r;i++){
            if(!seen[i]){
                dfs(i,grid,seen);
                count++;
            }
        }
        return count;
    }
}