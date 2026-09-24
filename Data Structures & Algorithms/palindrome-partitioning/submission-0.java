class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        
        return ans;
    }

    // sample log
    /*
    a a b
    aa b
    aab 
    a ab
    */
    public void dfs(int start, String word, List<String> path) {
        if (start >= word.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < word.length(); end++) {
            String curr = word.substring(start, end+1);
            if(isPalindrome(curr)) {
                path.add(curr);
                dfs(end+1, word, path);
                path.remove(path.size() - 1);
            }
        }
    }
    

    public boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length()-1;
        while(i < j) {
            if (word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
