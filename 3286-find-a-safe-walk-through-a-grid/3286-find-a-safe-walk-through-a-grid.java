class Solution {

    static int solve(int r, int c, int[][] grid, int health,
                     Integer[][][] dp, boolean[][][] visiting) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        if (grid[r][c] == 1) {
            health--;
        }

        if (health <= 0) {
            return Integer.MIN_VALUE;
        }

        if (r == grid.length - 1 &&
            c == grid[0].length - 1) {
            return health;
        }

        if (dp[r][c][health] != null) {
            return dp[r][c][health];
        }

        if (visiting[r][c][health]) {
            return Integer.MIN_VALUE;
        }

        visiting[r][c][health] = true;

        int up = solve(r - 1, c, grid, health, dp, visiting);
        int down = solve(r + 1, c, grid, health, dp, visiting);
        int left = solve(r, c - 1, grid, health, dp, visiting);
        int right = solve(r, c + 1, grid, health, dp, visiting);

        visiting[r][c][health] = false;

        return dp[r][c][health] = Math.max(
            Math.max(up, down),
            Math.max(left, right)
        );
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = grid.get(i).get(j);
            }
        }

        Integer[][][] dp = new Integer[n][m][health + 1];

        boolean[][][] visiting = new boolean[n][m][health + 1];

        int sum = solve(0, 0, matrix, health, dp, visiting);

        return sum >= 1;
    }
}