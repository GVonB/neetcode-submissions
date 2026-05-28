class Solution {
    // Return shortest substring of s, s.t. every character in t,
    // including duplicates, is present in the substring.
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        int minLeftWindow = Integer.MAX_VALUE;
        int minRightWindow = Integer.MAX_VALUE;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // Fill tMap with frequencies of chars in String t.
        for (int i = 0; i < t.length(); i++) {
            char tCurr = t.charAt(i);
            tMap.put(tCurr, tMap.getOrDefault(tCurr, 0) + 1);
        }

        int have = 0, need = tMap.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);

            if (tMap.containsKey(rChar) && window.get(rChar).equals(tMap.get(rChar))) {
                have++;
            }

            while (have == need) {
                int windowSize = r - l + 1;
                if (windowSize < resLen) {
                    resLen = windowSize;
                    res[0] = l;
                    res[1] = r;
                }
                char lChar = s.charAt(l);
                window.put(lChar, window.getOrDefault(lChar, 0) - 1);
                if (tMap.containsKey(lChar) && window.get(lChar) < tMap.get(lChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
