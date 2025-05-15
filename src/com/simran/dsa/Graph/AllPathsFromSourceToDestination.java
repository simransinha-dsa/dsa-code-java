package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToDestination {
    public static void main(String[] args) {
        allPathsSourceTarget(new int[][] {{1 , 2},  {3} , {3} , {}});
    }

    // Leetcode - 797 - All Paths From Source to Target
    // A directed graph in the question
    // If undirected graph , we need to have a visited boolean 

    /*
     *  0 -> 1
     *  |    |
     *  2 -> 3
     */

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph , allPaths , path , 0 , n-1);

        return allPaths;
    }

    public static void dfs(int[][] graph , List<List<Integer>> allPaths , List<Integer> path , int curr , int target) {
        if(curr == target) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < graph[curr].length ; i++) {
            int neighbor = graph[curr][i];
            path.add(neighbor);
            dfs(graph , allPaths , path , neighbor , target);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> allPathsUsingBFS(int n , int[][] edges , int source , int target) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Queue<List<Integer>> queue = new LinkedList<>();

        List<Integer> startPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        startPath.add(source);

        queue.add(startPath);

        while(!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);

            for(int nextNode: graph.get(lastNode)) {
                List<Integer> tempPath = new ArrayList<>(path);
                tempPath.add(nextNode);
                if(nextNode == target) {
                    allPaths.add(new ArrayList<>(tempPath));
                } else {
                    queue.add(new ArrayList<>(tempPath));
                }
            }
        }
        return allPaths;
    }
}
