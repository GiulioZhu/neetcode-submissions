class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[][] map = new int[n][n];
        for (int[] e : edges) {
            map[e[0]][e[1]] = 1;
            map[e[1]][e[0]] = 1;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.addLast(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            HashSet<Integer> visiting = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (map[node][i] == 0) continue;
                if (visited[i]) return false; // cycle detection
                visiting.add(i);
                map[i][node] = 0;
                map[node][i] = 0;
                queue.addLast(i);
                visited[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
