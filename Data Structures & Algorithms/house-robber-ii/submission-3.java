class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Rob the first house, skip last
        int[] dp = new int[n];
        dp[0] = nums[0];  // rob first house
        dp[1] = nums[0];
        for (int i = 2; i < n - 1; i++) {
            int robCurr = nums[i];
            dp[i] = Math.max(dp[i - 2] + robCurr, dp[i - 1]);
        }
        int robFirst = dp[n - 2];

        // Skip the first house, rob last
        dp[0] = 0;
        dp[1] = nums[1];  // rob second house
        for (int i = 2; i < n; i++) {
            int robCurr = nums[i];
            dp[i] = Math.max(dp[i - 2] + robCurr, dp[i - 1]);
        }
        int skipFirst = dp[n - 1];

        return Math.max(robFirst, skipFirst);

    }
}
