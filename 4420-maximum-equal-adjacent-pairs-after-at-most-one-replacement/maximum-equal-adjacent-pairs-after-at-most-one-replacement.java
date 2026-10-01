class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int prev = -1;
        int cnt = 1;
        int total = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]) {
                if(prev != -1) {
                    int a = Math.min(prev, nums[i-1]);
                    int b = Math.max(prev, nums[i-1]);
                    map.putIfAbsent(a, new HashMap<>());
                    HashMap<Integer, Integer> map1 = map.get(a);
                    map1.put(b, map1.getOrDefault(b, 0)+1);
                }
                total += cnt-1;
                cnt = 0;
                prev = nums[i-1];
            }
            cnt++;
        }
        total += cnt - 1;
        if(prev != -1) {
            int a = Math.min(prev, nums[n-1]);
            int b = Math.max(prev, nums[n-1]);
            map.putIfAbsent(a, new HashMap<>());
            HashMap<Integer, Integer> map1 = map.get(a);
            map1.put(b, map1.getOrDefault(b, 0)+1);
        }

        int ans = total;

        for(int key: map.keySet()) {
            HashMap<Integer, Integer> map1 = map.get(key);
            for(int key1: map1.keySet()) {
                int curr = total + map1.get(key1);
                ans = Math.max(ans, curr);
            }
        }

        return ans;
    }
}