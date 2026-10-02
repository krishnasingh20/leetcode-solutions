class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(2*n, 0, "");
        return ans;
    }
    public void generate(int n, int open, String curr) {
        if(n == 0) {
            if(open == 0) {
                ans.add(curr);
            }
            return;
        }

        generate(n-1, open+1, curr+'(');
        if(open > 0) {
            generate(n-1, open-1, curr+')');
        }
    }
}