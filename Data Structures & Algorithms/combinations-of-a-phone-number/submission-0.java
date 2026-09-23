class Solution {
    HashMap<Character, String> map = new HashMap<>();
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return combinations;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(0, digits, "");
        return combinations;
    }

    public void dfs(int index, String digits, String path) {
        if (path.length() == digits.length()) {
            combinations.add(path);
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String letters = map.get(digit);

            for (char letter : letters.toCharArray()) {
                path += letter;
                dfs(i+1, digits, path);
                path = path.substring(0, path.length()-1);
            }
        }

    }
}
