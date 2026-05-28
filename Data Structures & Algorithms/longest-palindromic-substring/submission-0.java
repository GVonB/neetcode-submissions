class Solution {
    int leftRes = 0;
    int rightRes = 0;
    public String longestPalindrome(String s) {
        // Check all middle values
        for (int i = 0; i < s.length(); i++) {
            expandFromBounds(s, i, i);
            expandFromBounds(s, i, i + 1);
        }
        return s.substring(leftRes, rightRes + 1);
    }
    private void expandFromBounds(String s, int leftB, int rightB) {
        while (leftB >= 0 && rightB < s.length() && s.charAt(leftB) == s.charAt(rightB)) {
            if ((rightB - leftB) > rightRes - leftRes) {
                leftRes = leftB;
                rightRes = rightB;
            }
            leftB--;
            rightB++;
        }
    }
}
