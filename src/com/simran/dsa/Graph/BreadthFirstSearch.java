package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    
    public static void main(String[] args) {
        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyList(4 , new int[][] {{0 , 1} , {0 , 2} , {1 , 2} , {2 , 3}});
        List<Integer> result = bfs(graph);
        for(int i = 0 ; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        System.out.println();
    }

    public static List<Integer> bfs(List<List<Integer>> adj) {
        // code here
        // O(v + e) // if v is too large then e or vice versa
        boolean[] visited = new boolean[adj.size()];
        
        ArrayList<Integer> result = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        visited[0] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(int i = 0 ; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i);
                if(!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        
        return result;
    }

    // if we need to traverse on a graph with disconnected components 
    // then we need to have util function with exact code of bfs
    // that util needs to be called in a on loop of visited boolean
    // because disconnected components will not be visited on one go
}

