class Solution {
    int m;
    int n;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Boolean[m][n][m+n];
        return hasValid(grid, 0, 0, 0);
    }

    public boolean hasValid(char[][] grid, int i, int j, int open) {
        if(i == m - 1 && j == n - 1) {
            open += (grid[i][j] == '(' ? 1 : -1);
            return open == 0;
        }

        if(dp[i][j][open] != null) {
            return dp[i][j][open];
        }

        boolean ans = false;
        int curr = open + (grid[i][j] == '(' ? 1 : -1);

        if(i+1 < m) {
            if(curr >= 0) {
                ans |= hasValid(grid, i+1, j, curr);
            }
        }

        if(ans) {
            return dp[i][j][open] = true;
        }

        if(j+1 < n) {
            if(curr >= 0) {
                ans |= hasValid(grid, i, j+1, curr);
            }
        }

        return dp[i][j][open] = ans;
    }
}