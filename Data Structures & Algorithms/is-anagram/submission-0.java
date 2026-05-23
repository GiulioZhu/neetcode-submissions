class Solution {
    public boolean isAnagram(String s, String t) {
        char[] word1 = s.toCharArray();
        char[] word2 = t.toCharArray();

        Arrays.sort(word1); Arrays.sort(word2);

        if (word1.length != word2.length) return false;
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) return false;
        }
        return true;
    }
}
