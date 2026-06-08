class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        if (hashset.size() != nums.length) return true;
        return false;
    }
}