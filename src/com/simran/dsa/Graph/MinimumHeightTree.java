package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTree {
    public static void main(String[] args) {
        mhtBruteForce(4 , new int[][] {{1 , 0} , {1 , 2} , {1 , 3}});
    }

    public static List<Integer> mhtBruteForce(int n , int[][] edges) {

        // This will give TLE
        List<Integer> roots = new ArrayList<>();
        List<Integer> rootLabels = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            roots.add(i);
        }

        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer , Integer> heights = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
            heights.put(i , 0);
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        
        int minHeight = Integer.MAX_VALUE;
        for(int i = 0 ; i < roots.size(); i++) {
            boolean[] visited = new boolean[n];
            int height = dfs(graph , visited , i);
            heights.put(i, height - 1); // removing the root
        }

        for (Map.Entry<Integer, Integer> entry : heights.entrySet()) {
            if (entry.getValue() < minHeight) {
                minHeight = entry.getValue();
                rootLabels.clear();
                rootLabels.add(entry.getKey());
            } else if (entry.getValue() == minHeight) {
                rootLabels.add(entry.getKey());
            }
        }
        return rootLabels;
    }

    public static int dfs(List<List<Integer>> graph , boolean[] vis , int curr ) {
        vis[curr] = true;
        int maxDepth = 0;
        for(int neighbor: graph.get(curr)) {
            if(!vis[neighbor]) {
                maxDepth = Math.max(maxDepth , dfs(graph, vis, neighbor));
            }
        }

        return maxDepth + 1 ; // 1 for root;
    }
}
