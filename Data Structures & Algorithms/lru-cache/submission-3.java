class LRUCache {
    LinkedList<Integer> list;
    HashMap<Integer, Integer> map;
    int size;

    public LRUCache(int capacity) {
        this.list = new LinkedList<>();
        this.size = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!this.map.containsKey(key)) return -1;
        this.list.removeFirstOccurrence(key);
        this.list.addLast(key);
        return this.map.get(key);
    }
    
    public void put(int key, int value) {
        if (this.list.contains(key)) {
            this.list.removeFirstOccurrence(key);
            this.list.addLast(key);

            this.map.put(key, value);
        } else if (this.list.size() < this.size) {
            this.list.addLast(key);
        }  else {
            this.map.remove(this.list.poll());
            this.list.addLast(key);
        }
        this.map.put(key, value);
    }
}
