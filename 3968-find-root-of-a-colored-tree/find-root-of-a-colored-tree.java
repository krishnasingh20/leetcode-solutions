class Solution {
    String colors;
    List<List<Integer>> tree = new ArrayList<>();
    int n;
    public int findColoredRoot(int[][] edges, String colors) {
        n = colors.length();
        this.colors = colors;

        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++) {
            if(tree.get(i).size() == 3) {
                continue;
            }
            if(check(i) != -1) {
                return i;
            }
        }

        return -1;
    }

    public int check(int i) {
        char c = colors.charAt(i);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(i);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int rv = q.poll();
                visited[rv] = true;
                for(int child: tree.get(rv)) {
                    if(!visited[child]) {
                        if(!valid(c, colors.charAt(child))) {
                            return -1;
                        }
                        q.add(child);
                    }
                }
            }
            c = next(c);
        }

        return i;
    }

    private boolean valid(char c, char curr) {
        return (c == 'R' && curr == 'B') || (c == 'B' && curr == 'W') || (c == 'W' && curr == 'R');
    }

    private char next(char c) {
        if(c == 'R') {
            return 'B';
        }
        if(c == 'B') {
            return 'W';
        }
        return 'R';
    }
}