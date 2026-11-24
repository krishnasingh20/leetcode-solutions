class Solution {
    long[][] dp;
    public long maxDifference(int[] nums) {
        dp = new long[2][nums.length];
        for(long[] d: dp) {
            Arrays.fill(d, -1);
        }
        return maxDiff(nums, 0, 0);
    }
    public long maxDiff(int[] nums, int i, int turn) {
        if(i == nums.length) {
            return 0;
        }
        if(dp[turn][i] != -1) {
            return dp[turn][i];
        }

        long ans = 0;
        if(turn == 0) {
            long a = nums[i];
            if(a % 3 == 0) {
                a += maxDiff(nums, i+1, 1);
            }
            else {
                a += maxDiff(nums, i+1, 0);
            }
            long b = Long.MIN_VALUE;
            if(i+1 < nums.length) {
                b = nums[i] + nums[i+1];
                if(b % 3 == 0) {
                    b += maxDiff(nums, i+2, 1);
                }
                else {
                    b += maxDiff(nums, i+2, 0);
                }
            }
            ans = Math.max(a, b);
        }
        else {
            long a = nums[i];
            if(a % 3 == 0) {
                a += maxDiff(nums, i+1, 1);
            }
            else {
                a += maxDiff(nums, i+1, 0);
            }
            long b = Long.MIN_VALUE;
            if(i+1 < nums.length) {
                b = nums[i] + nums[i+1];
                if(b % 3 == 0) {
                    b += maxDiff(nums, i+2, 1);
                }
                else {
                    b += maxDiff(nums, i+2, 0);
                }
            }
            ans = Math.max(a, b);
        }
        return dp[turn][i] = turn == 0 ? ans : -ans;
    }
}