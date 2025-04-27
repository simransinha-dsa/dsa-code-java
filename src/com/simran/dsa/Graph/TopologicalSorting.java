package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String[] args) {
        List<Integer> result = topologicalSortingUsingDFS(new int[][] {{1 , 0} , {1 , 2}},  4);

        List<Integer> result1 = topologicalSortingUsingBFS(new int[][] {{1 , 0} , {1 , 2}},  4);

        for(int node: result) {
            System.out.print(node + " ");
        }
        System.out.println();

        for(int node: result1) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static List<Integer> topologicalSortingUsingDFS(int[][] edges ,int n) {
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

    public static List<Integer> topologicalSortingUsingBFS(int[][] edges ,int n) {
        // Kahn's Algorithm
        // term indegree - number of incoming arrow to given node 
        // so in topological sorting , nodes with indegree 0 should come first

        List<Integer> result = new ArrayList<>();
        // Step 1 - Find Indegree
       int[] indegree = new int[n];
       for(int[] edge: edges) {
            indegree[edge[1]]++;
       }

       // Step 2 - Add those which have 0 indegree
       Queue<Integer> queue = new LinkedList<>();

       for(int i = 0 ; i < n ; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
       }

       List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyListDirectedGraph(n, edges);

       while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(int i = 0 ; i < graph.get(node).size(); i++) {
                indegree[graph.get(node).get(i)]--;
                if(indegree[graph.get(node).get(i)] == 0) {
                    queue.add(graph.get(node).get(i));
                }
            }
       }

       return result;
    }
}
