class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (freqMap.containsKey(currValue)) {
                return true;
            }
            freqMap.put(currValue, 1);
        }
        return false;
    }
}