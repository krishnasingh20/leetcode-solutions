class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == ')') {
                if(sb1.length() != 0) {
                    sb1.reverse();
                    st.push(sb1.toString());
                    sb1.setLength(0);
                }
                st.push(")");
            }
            else if(s.charAt(i) == '(') {
                sb1.reverse();
                while(!st.peek().equals(")")) {
                    sb1.append(st.pop());
                }
                sb1.reverse();
                st.pop();
                while(!st.isEmpty() && !st.peek().equals(")")) {
                    sb1.append(st.pop());
                }
                st.push(sb1.toString());
                sb1.setLength(0);
            }
            else {
                sb1.append(s.charAt(i));
            }
        }

        sb1.reverse();
        sb1.append((st.isEmpty() ? "" : st.pop()));

        return sb1.toString();
    }
}