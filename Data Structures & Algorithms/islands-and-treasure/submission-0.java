class Solution {
    LinkedList<int[]> queue = new LinkedList<>();
    boolean[][] visited;

    public void islandsAndTreasure(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0]; int y = point[1];
                grid[x][y] = distance;

                addRoom(x + 1, y, grid);
                addRoom(x, y + 1, grid);
                addRoom(x - 1, y, grid);
                addRoom(x, y - 1, grid);
            }
            distance++;
        }
    }

    public void addRoom(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (visited[x][y]) return;
        if (grid[x][y] == -1) return;
        queue.addLast(new int[] {x, y});
        visited[x][y] = true;
    }
}
