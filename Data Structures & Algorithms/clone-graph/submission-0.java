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
    LinkedList<Node> queue = new LinkedList<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] clones = new Node[101];

        clones[node.val] = new Node(node.val);
        queue.add(node);

        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            List<Node> adj = tmp.neighbors;
            for (Node n : adj) {
                if (clones[n.val] == null) {
                    clones[n.val] = new Node(n.val);
                    queue.addLast(n);
                }
                clones[tmp.val].neighbors.add(clones[n.val]);
            }
        }

        return clones[node.val];
    }
}