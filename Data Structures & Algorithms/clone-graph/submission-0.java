/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }
    private Node dfs(Node node) {
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node.val, clone);

        for (Node adj : node.neighbors) {
            clone.neighbors.add(dfs(adj));
        }

        return clone;
    }
}