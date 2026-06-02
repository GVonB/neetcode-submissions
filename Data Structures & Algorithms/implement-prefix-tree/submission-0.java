class PrefixTree {
    private TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        int wordItr = 0;
        TreeNode curr = root;
        while(wordItr < word.length()) {
            char currChar = word.charAt(wordItr);
            if (!curr.map.containsKey(currChar)) {
                curr.map.put(currChar, new TreeNode()); 
            }
            curr = curr.map.get(currChar);
            wordItr++;
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.map.containsKey(currChar)) {
                return false;
            }
            curr = curr.map.get(currChar);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (!curr.map.containsKey(currChar)) {
                return false;
            }
            curr = curr.map.get(currChar);
        }
        return true;
    }

    private static class TreeNode {
        boolean isEndOfWord;
        HashMap<Character, TreeNode> map;

        TreeNode() {
            map = new HashMap<>();
        }
    }
}
