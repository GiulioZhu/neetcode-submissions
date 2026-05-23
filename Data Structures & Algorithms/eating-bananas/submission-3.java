class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];
        int min = right;

        if (h == piles.length) return right;

        while (left <= right) {
            int mid = (left + right)/2;
            int time = 0;

            for (int pile : piles) {
                time += Math.ceil((double) pile/mid);
            }
            if (time > h) {
                left = mid + 1;
            } else {
                if (mid < min) min = mid;
                right = mid - 1;
            }
            System.out.println(mid);
        }
        return min;
    }
}
