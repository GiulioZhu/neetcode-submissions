class Solution {
    int[][] taken;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        taken = new int[1001][1001];
        Arrays.sort(prerequisites, (obj1, obj2) -> {
            int[] pre1 = obj1;
            int[] pre2 = obj2;
            if (pre1[0] <= pre2[0]) return -1;
            else return 1;
        });
        for (int[] p : prerequisites) {
            taken[p[0]][p[1]] = 1;
            if (taken[p[1]][p[0]] == 1) return false;
        }
        return true;
    }
}
