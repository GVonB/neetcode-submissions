class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Rob the first house, skip last
        int prev2 = nums[0];
        int prev1 = nums[0];
        for (int i = 2; i < n - 1; i++) {
            int currMax = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = currMax;
        }
        int robFirst = Math.max(prev2, prev1);

        // Skip the first house, rob last
        prev2 = 0;
        prev1 = nums[1];  // rob second house
        for (int i = 2; i < n; i++) {
            int currMax = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = currMax;
        }
        int skipFirst = Math.max(prev2, prev1);

        return Math.max(robFirst, skipFirst);

    }
}
