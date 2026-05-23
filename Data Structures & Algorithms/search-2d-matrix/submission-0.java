class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length * matrix[0].length - 1;

        while (i <= j) {
            int mid = (i + j)/2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            System.out.println(matrix[x][y]);
            if (matrix[x][y] > target) j = mid-1;
            else if (matrix[x][y] < target) i = mid+1;
            else return true;
        }
        return false;
    }
}
