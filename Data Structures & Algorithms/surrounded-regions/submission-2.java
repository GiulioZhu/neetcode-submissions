class Solution {
    boolean[][] infected;
    public void solve(char[][] board) {
        infected = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, board);
            dfs(i, board[0].length - 1, board);
        }
        for (int j = 0; j < board[0].length; j++) {
            dfs(0, j, board);
            dfs(board.length - 1, j, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!infected[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if (infected[x][y]) return;
        if (board[x][y] == 'X') return;
        infected[x][y] = true;
        dfs(x + 1, y, board);
        dfs(x, y + 1, board);
        dfs(x - 1, y, board);
        dfs(x, y - 1, board);
    }
}
