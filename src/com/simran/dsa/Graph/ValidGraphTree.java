package com.simran.dsa.Graph;

import java.util.List;

public class ValidGraphTree {

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][] {{0 ,1} , {1 , 2} , {2 , 3} , {1 , 3} , {1 , 4}}));
    }

    public static List<List<Integer>>  createGraph(int[][] edges, int n) {
        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyList(n, edges);
        return graph;
    }
    public static boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length) return false;
        boolean[] vis = new boolean[n];
        List<List<Integer>>  graph = createGraph(edges , n);

        // we don't have to check for cycle of the tree
        // that will be automatically calculated using line 24
        // egde will greater only if there is cycle


        isCycle(graph, vis,0);

        for(int i = 0 ; i < n ; i++) {
            if(!vis[i]) return false;
        }

        return true;
    }

    public static void isCycle(List<List<Integer>> graph , boolean[] vis , int curr) {
        vis[curr] = true;

        for(int i = 0 ; i < graph.get(curr).size() ; i++) {
            int neighbor = graph.get(curr).get(i);
            if(!vis[neighbor]) {
                isCycle(graph, vis , neighbor);
            }
        }
    }
}
