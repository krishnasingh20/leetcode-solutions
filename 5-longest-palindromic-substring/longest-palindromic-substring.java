class Solution {
    int l = -1;
    int r = -1;
    int ans = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            palindrome(s, i, i);
            palindrome(s, i, i+1);
        }

        return ans == Integer.MIN_VALUE ? "" : s.substring(l, r+1);
    }
    public void palindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(j - i - 1 > ans) {
            ans = j - i - 1;
            l = i+1;
            r = j-1;
        }
    }
}