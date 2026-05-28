class Solution {
    public boolean isAnagram(String s, String t) {
        // Build a frequency map of characters in string s
        Map<Character, Integer> sFreqMap = new HashMap<>();
        Map<Character, Integer> tFreqMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sFreqMap.put(sChar, sFreqMap.getOrDefault(sChar, 0) + 1);
            tFreqMap.put(tChar, tFreqMap.getOrDefault(tChar, 0) + 1);
        }

        return sFreqMap.equals(tFreqMap);
    }
}
