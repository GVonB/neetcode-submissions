class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int robFirst = rob(nums, 0, nums.length - 1);
        int skipFirst = rob(nums, 1, nums.length);
        return Math.max(robFirst, skipFirst);

    }
    private int rob(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;
        for (int i = start; i < end; i++) {
            int curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.max(prev2, prev1);
    }
}
