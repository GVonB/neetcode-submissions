class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int count = 0;
        for (int i = nums.length; i > 0; i--) {
            List<Integer> numsAtFreq = buckets[i];
            for (int num : numsAtFreq) {
                if (count < k) {
                    res[count] = num;
                    count++;
                }
            }
        }
        return res;
    }
}
