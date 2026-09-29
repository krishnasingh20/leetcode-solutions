class Solution {
    int m;
    int n;
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][m+n];
        for(int[][] d: dp) {
            for(int[] a: d) {
                Arrays.fill(a, -1);
            }
        }

        return hasValid(grid, 0, 0, 0) == 1;
    }

    public int hasValid(char[][] grid, int i, int j, int open) {
        if(i == m - 1 && j == n - 1) {
            open += (grid[i][j] == '(' ? 1 : -1);
            return open == 0 ? 1 : 0;
        }

        if(dp[i][j][open] != -1) {
            return dp[i][j][open];
        }

        int ans = 0;
        int curr = open + (grid[i][j] == '(' ? 1 : -1);

        if(i+1 < m) {
            if(curr >= 0) {
                ans += hasValid(grid, i+1, j, curr);
            }
        }

        if(ans == 1) {
            return dp[i][j][open] = 1;
        }

        if(j+1 < n) {
            if(curr >= 0) {
                ans += hasValid(grid, i, j+1, curr);
            }
        }

        return dp[i][j][open] = ans;
    }
}