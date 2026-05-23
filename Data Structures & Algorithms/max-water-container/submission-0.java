class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int i = 0; 
        int j = heights.length-1;

        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j-i);
            if (area > max) max = area;
            if (heights[i] <= heights[j]) i++;
            else {
                j--;
            }
        }
        return max;
    }
}
