class Solution {
    LinkedList<int[]> q = new LinkedList<>();
    boolean[][] visited;
    int fruits = 0;

    public int orangesRotting(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int time = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) fruits++;
            }
        }

        if (fruits == 0) return 0;

        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int x = point[0]; int y = point[1];
                add(x + 1, y, grid);
                add(x, y + 1, grid);
                add(x - 1, y, grid);
                add(x, y - 1, grid);
            }
            time++;
        }
        if (fruits != 0) return -1;
        return time;
    }

    public void add(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (visited[x][y]) return;
        if (grid[x][y] == 0) return;
        q.addLast(new int[]{x, y});
        visited[x][y] = true;
        fruits--;
    }
}
