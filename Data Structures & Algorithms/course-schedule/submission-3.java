class Solution {
    int[][] taken;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        taken = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            taken[p[0]][p[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, new boolean[numCourses], taken)) return false;;
        }
        return true;
    }

    public boolean dfs(int course, boolean[] visiting, int[][] taken) 
    {
        if (visiting[course]) return true;
        visiting[course] = true;
        
        for (int i = 0; i < taken.length; i++) {
            if (taken[course][i] == 0) continue;
            return dfs(i, visiting, taken);
        }
        return false;
    }
}
