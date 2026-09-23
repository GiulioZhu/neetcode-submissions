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

        for (int i = index; i < digits.length(); i++) {
            int digit = digits.charAt(i) - 48;
            String letters = map[digit];

            for (char letter : letters.toCharArray()) {
                path += letter;
                dfs(i+1, digits, path);
                path = path.substring(0, path.length()-1);
            }
        }

    }
}
