class Solution {

    static boolean solve(int r, int c, char[][] grid, int balance, Boolean[][][] dp) {

        if (r >= grid.length || c >= grid[0].length) {
            return false;
        }

        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        int remaining = (grid.length - 1 - r) + (grid[0].length - 1 - c);

        if (balance > remaining) {
            return false;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean right = solve(r + 1, c, grid, balance, dp);
        boolean down = solve(r, c + 1, grid, balance, dp);

        return dp[r][c][balance] = right || down;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Boolean[][][] dp = new Boolean[m][n][m + n + 1];

        return solve(0, 0, grid, 0, dp);
    }
}