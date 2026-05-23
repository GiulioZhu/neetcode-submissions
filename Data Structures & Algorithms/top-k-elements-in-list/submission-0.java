class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> bucket = new ArrayList<>();
        int[] ans = new int[k];

        for(int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, count+1);
            }
        }

        map.forEach((number, count) -> {
            int[] tmp = new int[2];
            tmp[0] = count;
            tmp[1] = number;
            bucket.add(tmp);
        });
        bucket.sort( (a, b) -> { return -1* Arrays.compare(a,b);} );

        for(int i = 0; i < k; i++) {
            ans[i] = bucket.get(i)[1];
        }
        return ans;

    }
}
