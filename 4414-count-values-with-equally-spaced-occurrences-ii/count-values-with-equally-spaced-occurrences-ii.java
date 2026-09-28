class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] a = null;

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                a = new int[3];
                a[0] = a[1] = -1;
                a[2] = i;
                map.put(nums[i], a);
            }
            else {
                a = map.get(nums[i]);
                a[0] = a[1];
                a[1] = a[2];
                a[2] = i;
            }

            if(a[0] != -1) {
                if(a[1] - a[0] != a[2] - a[1]) {
                    set.add(nums[i]);
                }
            }
        }

        int ans = map.size() - set.size();

        for(int key: map.keySet()) {
            a = map.get(key);
            if(a[0] == -1) {
                ans--;
            }
        }

        return ans;
    }
}