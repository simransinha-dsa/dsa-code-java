package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;

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
}
