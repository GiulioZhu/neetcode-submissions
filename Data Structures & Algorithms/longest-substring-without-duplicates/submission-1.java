class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        List<Character> list = new ArrayList<>();

        while (j < s.length()) {
            list.add(s.charAt(j));
            j++;
            if (j-i > max) max = j-i; 

            if (j < s.length() && list.contains(s.charAt(j))) {
                while(s.charAt(i) != s.charAt(j)) {
                    list.remove(0);
                    i++;
                }
                list.remove(0);
                i++;
            }
        }
        return max;
    }
}
