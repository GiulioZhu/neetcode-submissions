class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j, grid, visited)) islands++;
            }
        }
        return islands;
    }

    public boolean dfs(int x, int y, char[][] grid, boolean[][] visited) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) return false;
        if (visited[x][y]) return false;
        if (grid[x][y] == '0') return false;
        

        visited[x][y] = true;

        dfs(x-1, y, grid, visited);
        dfs(x, y-1, grid, visited);
        dfs(x+1, y, grid, visited);
        dfs(x, y+1, grid, visited);

        return true;
    }
}
