class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(i, j, grid));
            }
        }
        return max;
    }

    public int dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] == 0) return 0;
        grid[x][y] = 0;

        return 1 + dfs(x - 1, y, grid) +
        dfs(x, y - 1, grid) +
        dfs(x + 1, y, grid) +
        dfs(x, y + 1, grid);
    }
}
