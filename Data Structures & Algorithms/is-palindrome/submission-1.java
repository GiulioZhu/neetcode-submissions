class Solution {
    public boolean isPalindrome(String s) {
        String filtered = s.toLowerCase();
        String searchset = "abcdefghijklmnopqrstuvwxyz0123456789";

        char[] arr = filtered.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            if (searchset.indexOf(arr[i]) == -1) {
                i++; continue;
            }
            if (searchset.indexOf(arr[j]) == -1) {
                j--; continue;
            }

            if (arr[i] != arr[j]) return false;

            i++;
            j--;
        }
        return true;
    }
}
