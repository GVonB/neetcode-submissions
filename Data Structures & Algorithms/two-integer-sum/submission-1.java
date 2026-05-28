class Solution {
    public int[] twoSum(int[] nums, int target) {
        // i loops from index 0 to 1 away from end of array
        for (int i = 0; i < nums.length - 1; i++) {
            // j loops from index 1 to last element
            for (int j = 1; j < nums.length; j++) {
                // check if nums[i] + nums[j] equal target
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
