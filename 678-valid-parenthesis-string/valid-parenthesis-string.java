class Solution {
    int n;
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        n = s.length();
        dp = new Boolean[n][n];
        return checkValid(s, 0, 0);
    }

    public boolean checkValid(String s, int i, int open) {
        if(i == n) {
            return open == 0;
        }

        if(dp[i][open] != null) {
            return dp[i][open];
        }

        if(s.charAt(i) == '(') {
            if(checkValid(s, i+1, open+1)) {
                return dp[i][open] = true;
            }
        }
        else if(s.charAt(i) == ')') {
            if(open > 0 && checkValid(s, i+1, open-1)) {
                return dp[i][open] = true;
            }
        }
        else {
            if(checkValid(s, i+1, open+1)) {
                return dp[i][open] = true;
            }
            if(open > 0 && checkValid(s, i+1, open-1)) {
                return dp[i][open] = true;
            }
            if(checkValid(s, i+1, open)) {
                return dp[i][open] = true;
            }
        }
        return dp[i][open] = false;
    }
}