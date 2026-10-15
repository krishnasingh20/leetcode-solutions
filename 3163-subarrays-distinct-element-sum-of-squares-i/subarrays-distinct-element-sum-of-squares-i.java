class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int[] freq = new int[101];
        int dist = 0;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i; j < nums.size(); j++) {
                if(freq[nums.get(j)]++ == 0) {
                    dist++;
                }
                ans += (dist * dist);
            }
            Arrays.fill(freq, 0);
            dist = 0;
        }
        return ans;
    }
}