class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int twoBack = 1;
        int oneBack = 2;

        for (int i = 2; i < n; i++) {
            int curr = twoBack + oneBack;
            twoBack = oneBack;
            oneBack = curr;
        }
        return oneBack;
    }
}
