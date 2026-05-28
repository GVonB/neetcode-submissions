class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        Set<Character> seen = new HashSet<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (seen.contains(s.charAt(r))) {
                while(seen.contains(s.charAt(r))) {
                    seen.remove(s.charAt(l));
                    l++;
                }
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            seen.add(s.charAt(r));
        }

        return maxLen;
    }
}
