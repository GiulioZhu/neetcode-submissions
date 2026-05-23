class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Pair<Integer, Integer>, HashSet<Character>> table = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                HashSet<Character> block = new HashSet<>();
                char curr = board[i][r];

                if (curr == '.') continue;
                Pair<Integer, Integer> coordinates = new Pair<Integer, Integer>(i/3, r/3);
                if (row.contains(curr)) return false;
                row.add(curr);

                if (!table.containsKey(coordinates)) {
                    block.add(curr);
                    table.put(coordinates, block);
                } else if (table.get(coordinates).contains(curr)) return false;
                else {
                    block = table.get(coordinates);
                    block.add(curr);
                    table.put(coordinates, block);
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            HashSet<Character> col = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char curr = board[c][j];
                if (curr == '.') continue;
                int[] coordinates = {j/3, c/3};
                if (col.contains(curr)) return false;
                col.add(curr);
            }
        }
        return true;    
    }
}
