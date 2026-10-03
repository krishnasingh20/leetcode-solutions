class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int last = -1;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                if(!st.isEmpty()) {
                    st.pop();
                    ans = Math.max(ans, i - (!st.isEmpty() ? st.peek() : last));
                }
                else {
                    last = i;
                }
            }
        }

        return ans;
    }
}