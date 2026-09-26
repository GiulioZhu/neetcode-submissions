class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int count = 0;

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        Queue<int[]> queue = new LinkedList<>();

        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) pq.add(new int[]{-frequency[i], i});
        }

        while(!pq.isEmpty() || !queue.isEmpty()) {
            if (queue.peek() != null && queue.peek()[0] <= count) {
                int[] top = queue.poll();
                pq.add(new int[] {top[1], top[2]});
            }
            int[] task = pq.poll();
            if (task != null && task[0] < 0) {
                queue.add(new int[] {count + n, task[0] + 1, task[1]});
            }
            if (pq.isEmpty() && queue.isEmpty()) break;
            count++;
        }

        return count;
    }
}
