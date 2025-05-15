package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExists {
    public static void main(String[] args) {
        System.out.println(validPath(6, new int[][] {{0 , 1} , {0 , 2} , {3 , 5} , {5 , 4} , { 4 , 3}}, 0, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == destination) {
                return true;
            } else {
                for(int neighbor: graph.get(node)) {
                    if(!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        return false;
    }
}
