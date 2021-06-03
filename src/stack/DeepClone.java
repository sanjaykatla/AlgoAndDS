package stack;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class DeepClone {
    public Node cloneGraph(Node node) {

        return clone(node);
    }

    private Node clone(Node node) {

        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        List<Node> adjacency = new ArrayList<>();
        for (Node adj : node.neighbors) {
            adjacency.add(clone(adj));
        }
        newNode.neighbors = adjacency;
        return newNode;

    }
}
