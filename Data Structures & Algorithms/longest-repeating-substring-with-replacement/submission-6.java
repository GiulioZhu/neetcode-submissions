class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int max = 0;
        int ans = 0;
        int[] counts = new int[26];

        while(j < s.length()) {
            if (j - i - max <= k) {
                counts[s.charAt(j) - 'A']++;
                if (counts[s.charAt(j) - 'A'] > max) {
                    max = counts[s.charAt(j) - 'A'];
                    if (max > ans) ans = max;
                }
                j++;
                continue;
            }
            counts[s.charAt(j) - 'A']++;
            counts[s.charAt(i) - 'A']--;
            
            if (counts[s.charAt(j) - 'A'] > max) {
                max = counts[s.charAt(j) - 'A'];
                if (max > ans) ans = max;
            }
            if (s.charAt(i) == s.charAt(j)) max--;
            j++;
            i++;
        }
        return Math.min(s.length(), ans+k);

        
    }
}
