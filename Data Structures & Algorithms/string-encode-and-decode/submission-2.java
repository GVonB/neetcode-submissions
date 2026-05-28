class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i);
            int strLen = Integer.parseInt(str.substring(i, j));
            j++;
            decoded.add(str.substring(j, j + strLen));
            i = j + strLen;
        }
        return decoded;
    }
}
