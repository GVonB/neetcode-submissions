class Solution {
    public boolean isAnagram(String s, String t) {
        // Build a frequency map of characters in string s
        Map<Character, Integer> sFreqMap = new HashMap<>();
        Map<Character, Integer> tFreqMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0) + 1);
            tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sFreqMap.equals(tFreqMap);
    }
}
