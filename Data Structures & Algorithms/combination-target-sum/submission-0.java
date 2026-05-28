class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationHelper(nums, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void combinationHelper(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            combinationHelper(nums, target - nums[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
