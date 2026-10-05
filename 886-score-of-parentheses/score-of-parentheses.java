class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                st.push("(");
            }
            else {
                int curr = 1;
                if(!st.peek().equals("(")) {
                    String s1 = st.pop();
                    curr = 2 * Integer.parseInt(s1);
                }
                st.pop();
                if(!st.isEmpty() && !st.peek().equals("(")) {
                    curr += Integer.parseInt(st.pop());
                }
                st.push(Integer.toString(curr));
            }
        }
        return Integer.parseInt(st.pop());
    }
}