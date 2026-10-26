class Solution {
    class DSU {
        int[] parent;
        int[] size;
        long[] sum;
        int n;
        DSU(int m, int n) {
            this.n = (m*1000 + n) + 10;
            parent = new int[this.n];
            size = new int[this.n];
            sum = new long[this.n];
            for(int i = 0; i < this.n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        void build(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 0) {
                        continue;
                    }
                    int idx = i*1000 + j;
                    sum[idx] = grid[i][j];
                }
            }
        }

        int find(int node) {
            if(parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);

            if(p1 == p2) {
                return;
            }
            if(size[p1] < size[p2]) {
                parent[p1] = p2;
                size[p2] += size[p1];
                sum[p2] += sum[p1];
            }
            else {
                parent[p2] = p1;
                size[p1] += size[p2];
                sum[p1] += sum[p2];
            }
        }

        int calculate(int k) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                if(sum[i] > 0) {
                    set.add(find(i));
                }
            }

            int count = 0;
            for(int i: set) {
                if(sum[i] % k == 0) {
                    count++;
                }
            }
            return count;
        }
    }

    public int countIslands(int[][] grid, int k) {
        DSU dsu = new DSU(grid.length, grid[0].length);
        dsu.build(grid);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                if(j-1 >= 0 && i-1 >= 0 && grid[i][j-1] > 0 && grid[i-1][j] > 0) {
                    int u = (i*1000 + (j-1));
                    int v = ((i-1)*1000 + j);
                    dsu.union(u, v);
                    dsu.union(dsu.find(u), (i*1000 + j));
                }
                else if(j-1 >= 0 && grid[i][j-1] > 0) {
                    int u = i*1000 + (j-1);
                    dsu.union(u, i*1000 + j);
                }
                else if(i-1 >= 0 && grid[i-1][j] > 0) {
                    int u = (i-1)*1000 + j;
                    dsu.union(u, i*1000 + j);
                }
            }
        }
        
        return dsu.calculate(k);
    }
}