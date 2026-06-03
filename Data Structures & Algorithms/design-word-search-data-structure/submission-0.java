class WordDictionary {    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null) return;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.map.containsKey(currChar)) {
                curr.map.put(currChar, new TrieNode());
            }
            curr = curr.map.get(currChar);
        }
        curr.isEndWord = true;
    }

    public boolean search(String word) {
        if (word == null) return false;
        return dfs(root, word, 0);
    }
    
    private boolean dfs(TrieNode currNode, String word, int itr) {
        if (itr == word.length()) {
            return currNode.isEndWord;
        }
        char currChar = word.charAt(itr);
        if (currChar == '.') {
            for (TrieNode child : currNode.map.values()) {
                if (dfs(child, word, itr + 1)) return true;
            }
            return false;
        } else {
            if (!currNode.map.containsKey(currChar)) return false;
            return dfs(currNode.map.get(currChar), word, itr + 1);
        }
    }

    private class TrieNode {
        boolean isEndWord;
        HashMap<Character, TrieNode> map;
        TrieNode() {
            map = new HashMap<>();
            isEndWord = false; 
        }       
    }   
}
