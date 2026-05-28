class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedMap = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!sortedMap.containsKey(sorted)) {
                sortedMap.put(sorted, new ArrayList<>());
            } 
            sortedMap.get(sorted).add(str);
        }
        return new ArrayList<>(sortedMap.values());
    }
}
