class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j, grid)) islands++;
            }
        }
        return islands;
    }

    public boolean dfs(int x, int y, char[][] grid) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) return false;
        if (grid[x][y] == '0') return false;
        grid[x][y] = '0';

        dfs(x-1, y, grid);
        dfs(x, y-1, grid);
        dfs(x+1, y, grid);
        dfs(x, y+1, grid);
        
        return true;
    }
}
