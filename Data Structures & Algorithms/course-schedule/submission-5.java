class Solution {
    HashMap<Integer, List<Integer>> map;
    HashSet<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int[] p : prerequisites) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(p[0])) list = map.get(p[0]);
            list.add(p[1]);
            map.put(p[0], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int course) 
    {
        if (visiting.contains(course)) return false;
        if (!map.containsKey(course)) return true;

        visiting.add(course);
        
        for (int prerequisites : map.get(course)) {
            if (!dfs(prerequisites)) return false;
        }
        visiting.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
