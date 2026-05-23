class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap();
        HashMap<HashMap<Character,Integer>, Integer> dict = new HashMap<>();
        int index = 0;

        for (String str : strs) {
            char[] word = str.toCharArray();
            HashMap<Character, Integer> curr = new HashMap<>();
            for (char letter: word) {
                if (!curr.containsKey(letter)) {
                    curr.put(letter, 1);
                }
                int count = curr.get(letter);
                curr.put(letter, count+1);
            };
            List<String> list = new ArrayList<>();

            if (dict.isEmpty()) {
                list.add(str);
                dict.put(curr, index);
                map.put(index, list);
                index++;
            }
            else if (!dict.containsKey(curr)) {
                list.add(str);
                dict.put(curr, index);
                map.put(index, list);
                index++;
            } else {
                int ref = dict.get(curr);
                list = map.get(ref);
                list.add(str);
                map.put(ref, list);
            }
        }

        map.forEach( (i, value) -> ans.add(value));
        return ans;
    }
}
