class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        List<int[]> ll = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int cnt = 1;
        int total = 0;
        int ans = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]) {
                ll.add(new int[]{nums[i-1], cnt});
                total += cnt-1;
                cnt = 0;
            }
            cnt++;
        }
        ll.add(new int[]{nums[n-1], cnt});
        total += cnt - 1;

        if(ll.size() <= 2) {
            return n-1;
        }

        for(int i = 0; i < ll.size() - 1; i++) {
            int a = Math.min(ll.get(i)[0], ll.get(i+1)[0]);
            int b = Math.max(ll.get(i)[0], ll.get(i+1)[0]);
            map.putIfAbsent(a, new HashMap<>());
            HashMap<Integer, Integer> map1 = map.get(a);
            map1.put(b, map1.getOrDefault(b, 0)+1);
        }

        for(int i = 0; i < ll.size()-1; i++) {
            int a = Math.min(ll.get(i)[0], ll.get(i+1)[0]);
            int b = Math.max(ll.get(i)[0], ll.get(i+1)[0]);
            int curr = total + map.get(a).get(b);
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}