class Solution {
    static int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        return numberOfSet(n, k);
    }

    public int numberOfSet(int n, int k) {
        int[][][] dp = new int[2][n+1][k+1];

        for(int i = 0; i < n; i++) {
            for(int state = 0; state < 2; state++) {
                dp[state][i][0] = 1;
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= k; j++) {
                for(int state = 0; state <= 1; state++) {
                    int ans = 0;
                    if(state == 1) {
                        ans = (ans + dp[0][i][j-1]) % MOD;
                    }
                    else {
                        ans = (ans + dp[1][i+1][j]) % MOD;
                    }

                    //skip
                    ans = (ans + dp[state][i+1][j]) % MOD;
                    dp[state][i][j] = ans;
                }
            }
        }

        return dp[0][0][k];
    }
}