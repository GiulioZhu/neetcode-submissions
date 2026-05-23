class Solution {

    public String encode(List<String> strs) {
        String word = "";
        for (String str: strs) {
            word += str.length() + "#" + str;
        }
        return word;
    }

    public List<String> decode(String str) {
        List<String> words = new ArrayList<>();

        char[] arr = str.toCharArray();
        int curr = 0;
        int encoding = 0;

        
        while(encoding < arr.length) {
            String size = "";
            String word = "";

            if (arr[encoding] != '#') {
                encoding++;
                continue;
            }

            while(curr < encoding) {
                size += arr[curr++];
            }

            int len = Integer.parseInt(size);
            int start = encoding+1;
            for (curr = start; curr < start + len; curr++) {
                word += arr[curr];
            }
            words.add(word);
            
            curr = start + len;
            encoding = curr;
        }

        return words;
    }
}
