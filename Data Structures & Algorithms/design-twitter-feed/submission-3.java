class Twitter {
    Queue<int[]> records; // PriorityQueue [history, user_id, tweet_id]
    HashMap<Integer, HashSet<Integer>> follow_map;
    int history;

    public Twitter() {
        history = 1;
        records = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0]));
        follow_map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        records.add(new int[]{-history, userId, tweetId}); 
        history++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        HashSet<Integer> follows = new HashSet<>();
        Queue<int[]> feeds = new PriorityQueue<>(records);
        int i = 0;

        if (follow_map.containsKey(userId)) follows = follow_map.get(userId);
        System.out.println(follows);

        while (i < 10 && !feeds.isEmpty()) {
            int[] feed = feeds.poll();
            int u_id = feed[1];
            if (u_id == userId || follows.contains(u_id)) news.add(feed[2]);
            i++;
        }
        
        return news;

    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> follows;
        if (!follow_map.containsKey(followerId)) follows = new HashSet<>();
        else follows = follow_map.get(followerId);
        follows.add(followeeId);
        follow_map.put(followerId, follows);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> follows = follow_map.get(followerId);
        follows.remove(followeeId);
        follow_map.put(followerId, follows);
    }
}
