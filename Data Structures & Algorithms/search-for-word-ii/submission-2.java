class TrieNode {
    TrieNode[] children; 
    boolean isEndOfWord;

    // can also be omitted
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Solution {
    List<String> ans = new ArrayList<>();
    TrieNode root = new TrieNode();
    int rows;
    int cols;

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        for (String w : words) {
            insert(w);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // System.out.print("This is ");
                // System.out.print(i);
                // System.out.println(j);
                dfs(i, j, new StringBuilder(""), board, new boolean[rows][cols], root);
            }
        }

        return ans;
    }

    public void dfs(int x, int y, StringBuilder path, char[][] board, boolean[][] visited, TrieNode trie) {
        if (x < 0 || y < 0 || x >= rows || y >= cols) return; // out of bounds
        if (visited[x][y]) return;
        char c = board[x][y]; int i = c - 'a';
        // System.out.print(c);
        // System.out.print(x);
        // System.out.println(y);
        if (trie.children[i] == null) return;
        path.append(c);
        visited[x][y] = true;
        // System.out.println(path.toString());
        trie = trie.children[i];

        if (trie.isEndOfWord) {
            if (!ans.contains(path.toString())) ans.add(path.toString());
        }
        dfs(x+1, y, path, board, visited, trie);
        dfs(x, y+1, path, board, visited, trie);
        dfs(x-1, y, path, board, visited, trie);
        dfs(x, y-1, path, board, visited, trie);
        path.deleteCharAt(path.length() - 1);
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a'; // a = 0
            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
        
    }

}
