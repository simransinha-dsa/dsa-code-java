package com.simran.dsa.Graph;

import java.util.List;

public class CycleDetectionInDirectedGraph {
    
    public static void main(String[] args) {
        System.out.println(isCycleUsingDFS(4, new int[][] {{0 , 1} , {0 , 2} , {1 , 2} , {2 , 0} , {2 , 3}}));
    }

    public static boolean isCycleUsingDFS(int n , int[][] edges) {
        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyListDirectedGraph(n, edges);

        boolean[] recStack = new boolean[n];
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                if(isCycleUtil(graph , visited , recStack , i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(List<List<Integer>> graph , boolean[] visited , boolean[] recStack , int curr) {
        visited[curr] = true;
        recStack[curr] = true;

        for(int i = 0 ; i < graph.get(curr).size() ; i++) {
            int node = graph.get(curr).get(i);
            if(recStack[node]) {
                return true;
            } else if(!visited[node]) {
               if(isCycleUtil(graph , visited , recStack , node)) {
                return true;
               }
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static boolean isCycleUsingBFS(int n , int[][] edges) {
        // this can be done using topological sorting by BFS.
        // while adding to the queue , increase the count
        // if the count matches the number of nodes , then yes otherwise no

        return true;
    }
}
