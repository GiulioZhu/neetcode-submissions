class Solution {
    public boolean isValid(String s) {
        Stack<Character> stackOpen = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stackOpen.push(bracket);
                continue;
            }
            
            if (stackOpen.isEmpty()) return false;

            switch(bracket) {
                case ')':
                    if (stackOpen.pop() != '(') return false;
                    break;
                case '}':
                    if (stackOpen.pop() != '{') return false;
                    break;
                case ']':
                    if (stackOpen.pop() != '[') return false;
                    break;
            }
        }

        if (stackOpen.isEmpty()) return true;
        return false;
    }
}
