class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length, COL = heights[0].length;
        
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];
        
        for (int i = 0; i < ROW; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, COL-1, heights, atlantic);
        }

        for (int j = 0; j < COL; j++) {
            dfs(0, j, heights, pacific);
            dfs(ROW-1, j, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (atlantic[i][j] && pacific[i][j]) ans.add(Arrays.asList(i, j));
            }
        }

        return ans;
    }

    public void dfs(int x, int y, int[][] heights, boolean[][] ocean) {
        ocean[x][y] = true;

        for (int[] direction : directions) {
            int nx = x + direction[0], ny = y + direction[1];

            if (nx >= 0 && ny >= 0 && nx < heights.length && ny < heights[0].length
             && !ocean[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                dfs(nx, ny, heights, ocean);
            }
        }
    }


}
