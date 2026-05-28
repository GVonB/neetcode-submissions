class Solution {
    public int findMin(int[] nums) {
        // 1 2 3 4 5 6
        // 3 4 5 6 1 2
        // 5 6 1 2 3 4 (rotate 2 times)
        // 1 2 3 4 5 6 (rotate 0 or n times)
        // 6 1 2 3 4 5 (rotate 1 time)
        // 2 3 4 5 6 1 (rotate n - 1 times)

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
