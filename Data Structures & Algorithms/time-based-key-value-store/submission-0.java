class TimeMap {
    List<TimeMap> list = new ArrayList<>();
        HashMap<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> list;
        if (this.map.containsKey(key)) list = map.get(key);
        else list = new ArrayList<>();

        list.add(new Pair<String, Integer>(value, Integer.valueOf(timestamp)));
        this.map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if (!this.map.containsKey(key)) return "";

        List<Pair<String, Integer>> list = this.map.get(key);

        int i = 0;
        int j = list.size() - 1;

        while(i <= j) {
            int mid = (i+j)/2;
            Pair<String, Integer> pair = list.get(mid);
            if (pair.getValue() > timestamp) j = mid-1;
            else {
                i = mid + 1;
                ans = pair.getKey();
            }
        }
        
        return ans;
    }
}
