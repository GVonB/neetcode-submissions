class Solution {
    public boolean isAnagram(String s, String t) {
        // Build a frequency map of characters in string s
        Map<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            int freqCount = map.get(c);
            if (freqCount <= 0) {
                return false;
            }
            map.put(c, freqCount - 1);
        }
        return true;
    }
}
