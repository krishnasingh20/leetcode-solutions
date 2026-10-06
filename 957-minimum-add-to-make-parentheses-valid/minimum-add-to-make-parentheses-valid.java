class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int ans = 0;
        int open = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                open++;
            }
            else {
                ans += (open == 0 ? 1 : 0);
                open = (open > 0 ? open - 1 : 0);
            }
        }
        return ans+open;
    }
}