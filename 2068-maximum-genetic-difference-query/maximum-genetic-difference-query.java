class Solution {

    class Trie {
        class Node {
            Node one;
            Node zero;
            int oneCount = 0;
            int zeroCount = 0;
        }

        private Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node curr = root;
            for(int i = 18; i >= 0; i--) {
                if((num & (1 << i)) != 0) {
                    if(curr.one == null) {
                        curr.one = new Node();
                    }
                    curr = curr.one;
                    curr.oneCount++;
                }
                else {
                    if(curr.zero == null) {
                        curr.zero = new Node();
                    }
                    curr = curr.zero;
                    curr.zeroCount++;
                }
            }
        }

        void remove(int num) {
            Node curr = root;
            for(int i = 18; i >= 0; i--) {
                if((num & (1 << i)) != 0) {
                    curr = curr.one;
                    curr.oneCount--;
                }
                else {
                    curr = curr.zero;
                    curr.zeroCount--;
                }
            }
        }

        int find(int num) {
            Node curr = root;
            int ans = 0;

            for(int i = 18; i >= 0; i--) {
                if((num & (1 << i)) != 0) {
                    if(curr.zero != null && curr.zero.zeroCount > 0) {
                        curr = curr.zero;
                        ans |= (1 << i);
                    }
                    else if(curr.one != null && curr.one.oneCount > 0) {
                        curr = curr.one;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    if(curr.one != null && curr.one.oneCount > 0) {
                        curr = curr.one;
                        ans |= (1 << i);
                    }
                    else if(curr.zero != null && curr.zero.zeroCount > 0) {
                        curr = curr.zero;
                    }
                    else {
                        return -1;
                    }
                }
            }

            return ans;
        }
    }

    HashMap<Integer, List<int[]>> map = new HashMap<>();
    List<List<Integer>> tree = new ArrayList<>();
    int[] ans;
    Trie trie;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        int m = queries.length;
        int src = -1;
        ans = new int[m];

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            if(parents[i] == -1) {
                src = i;
            }
            else {
                tree.get(parents[i]).add(i);
            }
        }

        for(int i = 0; i < m; i++) {
            int node = queries[i][0];
            int val = queries[i][1];
            map.putIfAbsent(node, new ArrayList<>());
            map.get(node).add(new int[]{val, i});
        }

        trie = new Trie();

        trie.insert(src);
        dfs(src);

        return ans;
    }

    public void dfs(int node) {
        if(map.containsKey(node)) {
            calculate(node);
        }

        List<Integer> child = tree.get(node);

        for(int c: child) {
            trie.insert(c);
            dfs(c);
            trie.remove(c);
        }
    }
    
    public void calculate(int node) {
        List<int[]> ll = map.get(node);

        for(int[] l: ll) {
            ans[l[1]] = trie.find(l[0]);
        }
    }
}