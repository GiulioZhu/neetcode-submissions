class Solution {
    public boolean exist(char[][] board, String word) {
        int row_len = board.length;
        int col_len = board[0].length;

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (dfs(i, j, 0, board, new int[row_len][col_len], word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int index, char[][] board, int[][] visited, String word) {
        if (index == word.length()) return true;

        // out of bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;

        // check for visited
        if (visited[row][col] == 1) return false;
        

        if (board[row][col] != word.charAt(index)) return false;

        index++;
        visited[row][col] = 1;

        boolean found = dfs(row-1, col, index, board, visited, word) || dfs(row, col-1, index, board, visited, word) || dfs(row+1, col, index, board, visited, word) || dfs(row, col+1, index, board, visited, word);
        
        visited[row][col] = 0;
        index--;
        return found;
    }
}
