class Solution {
    public boolean canAliceWin(int n) {
        int curr = 0;
        for(int i = 10; i > 0; i--) {
            if(curr + i > n) {
                return i % 2 == 0 ? false: true;
            }
            curr += i;
        }

        return true;
    }
}