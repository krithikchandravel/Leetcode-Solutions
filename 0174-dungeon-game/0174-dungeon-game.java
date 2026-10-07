class Solution {
    static int solve(int r,int c,int[][] dungeon,Integer[][] dp,int row,int col){
        if(r>=row || c>=col){
            return Integer.MAX_VALUE;
        }
        if(dp[r][c]!=null){
            return dp[r][c];
        }
        if(r==row-1 && c==col-1){
            return Math.max(1,1-dungeon[r][c]);
        }
        int left = solve(r+1,c,dungeon,dp,row,col);
        int right = solve(r,c+1,dungeon,dp,row,col);

        int ans = Math.min(left,right);
        
        return dp[r][c] = Math.max(1,ans-dungeon[r][c]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        Integer[][] dp = new Integer[row][col];
        return solve(0,0,dungeon,dp,row,col);
    }
}