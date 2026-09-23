class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        int row_len = board.length;
        int col_len = board[0].length;

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                dfs(i, j, board, new int[row_len][col_len], word, "");
            }
        }
        return found;
    }

    public void dfs(int row, int col, char[][] board, int[][] visited, String word, String path) {
        
        if (path.length() == word.length()) {
            if (word.equals(path)) found = true;
            return;
        }

        if (visited[row][col] == 1) return;
        path += board[row][col];
        System.out.println(path);
        visited[row][col] = 1;

        if (row > 0) dfs(row-1, col, board, visited, word, path);
        if (col > 0) dfs(row, col-1, board, visited, word, path);
        if (row < board.length - 1) dfs(row+1, col, board, visited, word, path);
        if (col < board[0].length - 1) dfs(row, col+1, board, visited, word, path);
        
        path = path.substring(0, path.length() - 1);
        if (path.length() == 0) visited = new int[board.length][board[0].length];


    }
}
