package com.simran.dsa.Graph;

import java.util.List;

public class CycleDetectionInUndirectedGraph {
    public static void main(String[] args) {
        System.out.println(isCycle(new int[][] {{0 , 1} , {0 , 2} , {1 , 2} , {2 , 3}}));
    }

    public static boolean isCycle(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyList(edges.length, edges);

        for(int i = 0 ; i < visited.length ; i++) {
            if(!visited[i]) {
                if(cycleUtil(graph , visited , i , -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleUtil(List<List<Integer>> graph , boolean [] vis , int curr , int parent) {
        vis[curr] = true;

        for(int i = 0; i < graph.get(curr).size(); i++) {
            int node = graph.get(curr).get(i);
            if(!vis[node]) {
                if(cycleUtil(graph, vis, node, curr)) {
                    return true;
                }
            } else if(node != parent) {
                return true;
            }
        }

        return false;
    }
}
