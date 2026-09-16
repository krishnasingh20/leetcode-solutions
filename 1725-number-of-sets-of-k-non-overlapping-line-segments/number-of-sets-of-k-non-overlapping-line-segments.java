class Solution {

    int n;
    int[][][] dp;
    static int MOD = 1000000007;

    public int numberOfSets(int n, int k) {
        this.n = n;
        dp = new int[2][n][k+1];

        for(int[][] d: dp) {
            for(int[] d1: d) {
                Arrays.fill(d1, -1);
            }
        }

        return numberOfSet(0, k, 0);
    }

    public int numberOfSet(int i, int k, int state) {
        if(k == 0) {
            return 1;
        }

        if(i == n) {
            return 0;
        }

        if(dp[state][i][k] != -1) {
            return dp[state][i][k];
        }

        int ans = 0;
        if(state == 1) {
            ans = (ans + numberOfSet(i, k-1, 0)) % MOD;
        }
        else {
           ans = (ans + numberOfSet(i+1, k, 1)) % MOD;
        }

        int skip = numberOfSet(i+1, k, state);
        return dp[state][i][k] = (ans + skip) % MOD;
    }
}