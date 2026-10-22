class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int x = -1;
        int y = -1;
        int i = 0;
        int j = 0;

        while(valid(i, j, grid)) {
            char c = grid[i][j];
            grid[i][j] = 'X';
            x = i;
            y = j;
            if(c == 'R') {
                j++;
            }
            else if(c == 'L') {
                j--;
            }
            else if(c == 'U') {
                i--;
            }
            else {
                i++;
            }
        }

        return new int[]{x, y};
    }

    private boolean valid(int i, int j, char[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 'X';
    }
}