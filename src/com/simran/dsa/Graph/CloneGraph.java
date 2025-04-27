package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        // cloneGraph(node)
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

     public static Node cloneGraph(Node node) {
        Map<Node , Node> map = new HashMap<>();

        return dfs(node , map);
     }

     public static Node dfs(Node node , Map<Node , Node> map) {
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node , copy);

        for(int i = 0 ; i < node.neighbors.size() ; i++) {
            copy.neighbors.add(dfs(node.neighbors.get(i) , map));
        }

        return copy;
     }
}
