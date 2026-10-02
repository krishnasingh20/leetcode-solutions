class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, "");
        return ans;
    }
    public void generate(int n, int open, int close, String curr) {
        if(open == n && close == n) {
            ans.add(curr);
            return;
        }

        if(open < n) {
            generate(n, open+1, close, curr+'(');
        }
        if(close < open) {
            generate(n, open, close+1, curr+')');
        }
    }
}