package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String[] args) {
        List<Integer> result = topologicalSorting(new int[][] {{2 , 3} , {3 , 1} , {4 , 0}, {4 , 1} , {5 , 0} , {5 , 2}},  6);

        for(int node: result) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static List<Integer> topologicalSorting(int[][] edges ,int n) {
        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyListDirectedGraph(n, edges);

        boolean[] visited = new boolean[n];
        List<Integer> sortedNodes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                dfs(graph , visited , i , stack);
            }
        }
        while(!stack.isEmpty()) {
            sortedNodes.add(stack.pop());
        }
        return sortedNodes;
    } 

    public static void dfs(List<List<Integer>> graph , boolean[] visited , int curr , Stack<Integer> stack) {
        visited[curr] = true;

        for(int i = 0 ; i < graph.get(curr).size() ; i++) {
            int neighbor = graph.get(curr).get(i);
            if(!visited[neighbor]) {
                dfs(graph , visited , neighbor, stack);
            }
        }
        stack.push(curr);
    }
}
