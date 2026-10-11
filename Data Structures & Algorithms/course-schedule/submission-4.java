class Solution {
    int[][] taken;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        taken = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            taken[p[0]][p[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.print(i);
            if (dfs(i, 0, new boolean[numCourses], taken)) return false;;
        }
        return true;
    }

    public boolean dfs(int course, int index, boolean[] visiting, int[][] taken) 
    {
        System.out.println(course);
        if (index > taken.length) return false;
        if (taken[course][index] == 0) return false;
        if (visiting[course]) return true;
        visiting[course] = true;

        return dfs(course, index++, visiting, taken);
    }
}
