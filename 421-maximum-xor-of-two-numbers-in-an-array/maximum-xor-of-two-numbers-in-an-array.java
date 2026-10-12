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
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        Trie t = new Trie();

        for(int num: nums) {
            t.insert(num);
            ans = Math.max(ans, t.find(num));
        }

        return ans;
    }
}