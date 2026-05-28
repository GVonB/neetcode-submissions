class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> bucket = new HashMap<>();

        for (int num : hashMap.keySet()) {
            int numFreq = hashMap.get(num);
            if (!bucket.containsKey(numFreq)) {
                bucket.put(numFreq, new ArrayList<>());
            }
            bucket.get(numFreq).add(num);
        }

        int[] result = new int[k];
        for (int freq = nums.length; freq > 0; freq--) {
            if (bucket.containsKey(freq)) {
                List<Integer> list = bucket.get(freq);
                for (int num : list) {
                    result[--k] = num;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
