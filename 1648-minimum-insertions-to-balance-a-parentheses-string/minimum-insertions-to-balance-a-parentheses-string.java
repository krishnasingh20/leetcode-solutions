class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int ans = 0;
        int open = 0;
        int close = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                if(close > 0) {
                    ans += ((close & 1) == 1 ? 1 : 0);
                    int curr = (close / 2) + ((close & 1) == 1 ? 1 : 0);
                    if(curr >= open) {
                        ans += (curr - open);
                        open = 0;
                    }
                    else {
                        open -= curr;
                    }
                }
                close = 0;
                open++;
            }
            else {
                close++;
            }
        }

        ans += ((close & 1) == 1 ? 1 : 0);
        int curr = (close / 2) + ((close & 1) == 1 ? 1 : 0);
        if(curr >= open) {
            ans += (curr - open);
        }
        else {
            ans += ((open - curr) * 2);
        }

        return ans;
    }
}