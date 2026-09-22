class Solution {
    List<String> parenthesis = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return parenthesis;
    }

    public void dfs(int open, int closed, int n, String path) {
        if (open + closed == 2 * n && open == closed) {
            parenthesis.add(path);
            return;
        }
        
        for (char c: "()".toCharArray()) {
            if (open + closed > 2*n) break;
            path += c;
            if (c == '(' && open < n) {
                dfs(open+1, closed, n, path);
            }
            if (c == ')' && closed < open) {
                dfs(open, closed+1, n, path);
            }
            path = path.substring(0, path.length() - 1);
        }
        
    }
}
