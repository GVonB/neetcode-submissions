class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (k >= n) return n;

        int maxLen = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0, maxf = 0;

        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
            
            maxf = Math.max(maxf, freqMap.get(curr));
            int windowSize = r - l + 1;

            if (windowSize - maxf > k) {
                char lChar = s.charAt(l);
                freqMap.put(lChar, freqMap.get(lChar) - 1);
                l++;
            }
            windowSize = r - l + 1;
            maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }
}
