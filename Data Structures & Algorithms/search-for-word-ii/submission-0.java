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

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) {
            insert(w);
        }

        for (int i = 0; i < )

        return ans;
    }

    public boolean dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;

        
            
        return false;
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a'; // a = 0
            System.out.print(c);
            System.out.println(i);
            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }

}
