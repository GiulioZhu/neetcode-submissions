class Solution {
    LinkedList<Integer> queue = new LinkedList<>();
    List<List<Integer>> pre = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int finished = 0;
        int[] order = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            indegrees[p[0]]++;
            pre.get(p[0]).add(p[1]);
        }

        for (int indegree = 0; indegree < numCourses; indegree++) {
            if (indegrees[indegree] == 0) queue.addLast(indegree);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            order[index] = queue.poll();
            finished++;

            for (int i = 0; i < numCourses; i++) {
                if (pre.get(i).contains(order[index])) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) queue.add(i);
                }
            }
            index++;
        }
        if (finished == numCourses) return order;
        return new int[]{};
    }
}
