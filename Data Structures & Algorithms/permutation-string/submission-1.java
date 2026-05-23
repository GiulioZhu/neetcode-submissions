class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0;
        int j = 0;

        int[] ground = new int[26];
        int[] words = new int[26];
        for(int index = 0; index < s1.length(); index++) {
            ground[s1.charAt(index) - 'a']++;
        }

        while (j < s2.length()) {
            words[s2.charAt(j) - 'a']++;
            if (j < s1.length()) {
                j++;
                if (Arrays.compare(words, ground) == 0) return true;
                continue;
            }
            j++;
            
            words[s2.charAt(i) - 'a']--;
            i++;
            if (Arrays.compare(words, ground) == 0) return true;
        }
        return false;
        
    }
}
