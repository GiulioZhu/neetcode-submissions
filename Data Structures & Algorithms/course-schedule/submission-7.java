class Solution {
    LinkedList<Integer> queue = new LinkedList<>();
    int[][] map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new int[numCourses][numCourses];
        int[] indegrees = new int[numCourses];
        int finished = 0;

        for (int[] p : prerequisites) {
            map[p[0]][p[1]] = 1;
            indegrees[p[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            for (int i = 0; i < numCourses; i++) {
                if (map[i][course] == 0) continue;
                map[i][course] = 0;
                indegrees[i]--;
                if (indegrees[i] == 0) queue.addLast(indegrees[i]);
            }
        }

        if (finished == numCourses) return true;
        return false;
    }
}
