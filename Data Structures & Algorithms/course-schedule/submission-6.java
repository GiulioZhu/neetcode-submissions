class Solution {
    int[][] map;
    HashSet<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            map[p[0]][p[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int course) 
    {
        if (visiting.contains(course)) return false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[course][i] == 1) list.add(i);
        }
        if (list.isEmpty()) return true;
        

        visiting.add(course);
        
        for (int prerequisites : list) {
            if (!dfs(prerequisites)) return false;
        }
        visiting.remove(course);
        map[course] = new int[map.length];
        return true;
    }
}
