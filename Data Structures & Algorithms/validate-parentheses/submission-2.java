class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (pair.containsKey(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != pair.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
