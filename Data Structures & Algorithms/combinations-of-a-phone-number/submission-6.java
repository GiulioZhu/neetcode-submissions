class Solution {
    List<String> combinations = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return combinations;
        
        dfs(0, digits, "");
        return combinations;
    }

    public void dfs(int index, String digits, String path) {
        if (path.length() == digits.length()) {
            combinations.add(path);
            return;
        }

        for (char letter : map[digits.charAt(index) - 48].toCharArray()) {
            dfs(index+1, digits, path + letter);
        }
        

    }
}
