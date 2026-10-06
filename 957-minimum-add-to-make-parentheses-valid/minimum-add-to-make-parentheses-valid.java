class Solution {
    int[][] dp;
    public int minAddToMakeValid(String s) {
        int n = s.length();
        dp = new int[n][2*n];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return minAdd(s, 0, 0);
    }
    public int minAdd(String s, int i, int open) {
        if(i == s.length()) {
            return open;
        }

        if(dp[i][open] != -1) {
            return dp[i][open];
        }

        int ans = 0;
        if(s.charAt(i) == '(') {
            int a = minAdd(s, i+1, open+1);//(
            int b = 1 + minAdd(s, i+1, open+2);//((
            ans = Math.min(a, b);
            if(open > 0) {
                int c = 1 + minAdd(s, i+1, open);//)(
                ans = Math.min(ans, c);
            }
        }
        else {
            int a = 1 + minAdd(s, i+1, open);//()
            ans = a;
            if(open >= 2) {
                int b = 1 + minAdd(s, i+1, open-2);//))
                ans = Math.min(ans, b);
            }
            if(open >= 1) {
                int c = minAdd(s, i+1, open-1);//)
                ans = Math.min(ans, c);
            }
        }

        return dp[i][open] = ans;
    }
}