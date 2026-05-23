class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 1;
        for (int num: nums) {
            if (!map.containsKey(num-1)) {
                map.put(num, 1);
                continue;
            }
            int curr = map.get(num-1)+1;
            map.put(num, curr);
            if (curr > length) {
                length = curr;
            }
        }

        return length;

    }
}
