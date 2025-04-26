package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    
    public static void main(String[] args) {
        List<List<Edge>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyList(4);
        dfs(graph);
    }

    public static void dfs(List<List<Edge>> graph) {
        List<Integer> result1 = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];

        dfsUtil(graph , result1 , visited , 0);

        for(int i = 0 ; i < result1.size() ; i++) {
            System.out.print(result1.get(i) + " ");
        }

        System.out.println();

        List<Integer> resul2 = new ArrayList<>();

        dfsUtilIterative(graph, resul2, visited, 0);

        for(int i = 0 ; i < result1.size() ; i++) {
            System.out.print(result1.get(i) + " ");
        }

        System.out.println();
        
    }

    public static void dfsUtil(List<List<Edge>> graph , List<Integer> result , boolean[] vis , int curr) {
        // O(v + e)
        result.add(curr);
        vis[curr] = true;

        for(int i = 0 ; i < graph.get(curr).size(); i++) {
            Edge e = graph.get(curr).get(i);
            if(!vis[e.destination]) {
                dfsUtil(graph , result , vis , e.destination);
            }
        }
    }

    public static void dfsUtilIterative(List<List<Edge>> graph , List<Integer> result , boolean[] vis , int curr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(curr);
        vis[curr] = true;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);
            for(int i = 0 ; i < graph.get(node).size(); i++) {
                Edge e = graph.get(node).get(i);
                if(!vis[e.destination]) {
                    stack.push(e.destination);
                    vis[e.destination] = true;
                }
            }
        }
    }

    // if we need to traverse on a graph with disconnected components 
    // then we need to have util function with exact code of bfs
    // that util needs to be called in a for loop of visited boolean
    // because disconnected components will not be visited on one go
}
