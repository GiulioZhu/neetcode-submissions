class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 0;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            if ((mask & n) == mask) count++;
        }
        return count;
    }
}
