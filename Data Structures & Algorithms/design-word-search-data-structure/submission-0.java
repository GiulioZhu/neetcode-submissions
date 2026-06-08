class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (TrieNode trie: curr.children) {
                    if (trie != null && dfs(word, i+1, trie)) return true;
                }
            } else {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
        }
        return curr.isEndOfWord;
    }
}
