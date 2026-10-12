class Solution {
    class Trie {
        class Node {
            Node one;
            Node zero;
        }

        private Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node curr = root;
            for(int i = 30; i >= 0; i--) {
                if((num & (1 << i)) != 0) {
                    if(curr.one == null) {
                        curr.one = new Node();
                    }
                    curr = curr.one;
                }
                else {
                    if(curr.zero == null) {
                        curr.zero = new Node();
                    }
                    curr = curr.zero;
                }
            }
        }

        int find(int num) {
            Node curr = root;
            int ans = 0;

            for(int i = 30; i >= 0; i--) {
                if(curr == null) {
                    return -1;
                }

                if((num & (1 << i)) != 0) {
                    if(curr.zero != null) {
                        ans |= (1 << i);
                        curr = curr.zero;
                    }
                    else {
                        curr = curr.one;
                    }
                }
                else {
                    if(curr.one != null) {
                        curr = curr.one;
                        ans |= (1 << i);
                    }
                    else {
                        curr = curr.zero;
                    }
                }
            }

            return ans;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[][] arr = new int[m][3];

        for(int i = 0; i < m; i++) {
            arr[i][0] = queries[i][0];
            arr[i][1] = queries[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        int j = 0;
        int[] ans = new int[m];
        Trie trie = new Trie();

        for(int i = 0; i < m; i++) {
            while(j < n && nums[j] <= arr[i][1]) {
                trie.insert(nums[j++]);
            }
            ans[arr[i][2]] = trie.find(arr[i][0]);
        }

        return ans;
    }
}