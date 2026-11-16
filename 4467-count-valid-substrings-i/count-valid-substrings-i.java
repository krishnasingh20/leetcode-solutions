class Solution {
    public long countValidSubstrings(String s) {
        int len = 0;
        long ans = 0;
        int i = 0;
        int n = s.length();

        while(i < n) {
            if(i+1 < n && i+2 < n && s.charAt(i) == 'a' && s.charAt(i+1) == 'b' && s.charAt(i+2) == 'c') {
                ans += ((len + 1) * 2);
                len = 0;
            }
            else {
                len++;
            }
            ans += len;
            i++;
        }

        return ans;
    }
}