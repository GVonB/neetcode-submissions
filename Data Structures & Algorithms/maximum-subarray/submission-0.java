class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currVal = nums[i];
            currSum = Math.max(currSum + currVal, currVal);
            max = Math.max(max, currSum);
        }
        return max;
    }
}
