class Solution {
    static void dfs(int[][] grid,int cr,int cc,int target,int color){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]!=target){
            return;
        }
        grid[cr][cc] = color;
        dfs(grid,cr+1,cc,target,color);
        dfs(grid,cr-1,cc,target,color);
        dfs(grid,cr,cc-1,target,color);
        dfs(grid,cr,cc+1,target,color);
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int target = grid[sr][sc];
        if(grid[sr][sc]==color) return grid;
        dfs(grid,sr,sc,target,color);
        return grid;
    }
}