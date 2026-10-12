class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[][] map = new int[n][n];
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int[] e : edges) {
            map[e[0]][e[1]] = 1;
            map[e[1]][e[0]] = 1;
        }

        
        for (int index = 0; index < n; index++) {
            if (visited[index]) continue;
            queue.addLast(index);
            visited[index] = true;

            while(!queue.isEmpty()) {
                int node = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (map[node][i] == 0) continue;
                    queue.addLast(i);
                    visited[i] = true;
                    map[node][i] = 0;
                    map[i][node] = 0;
                }
            }
            components++;
        }

        return components;
    }
}
