class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currNum = num;
                int seqLen = 1;
                while (numSet.contains(currNum + 1)) {
                    currNum++;
                    seqLen++;
                }
                maxLen = Math.max(maxLen, seqLen);
            }
        }
        return maxLen;
    }
}
