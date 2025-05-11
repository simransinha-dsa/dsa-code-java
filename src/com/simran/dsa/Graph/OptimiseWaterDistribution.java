package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimiseWaterDistribution {

    public static void main(String[] args) {
        System.out.println(minCostToSupplyWater(3, new int[] {1 ,2 ,2}, new int[][] {{1 , 2 , 1} , {2 , 3 , 1}}));
    }
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < wells.length ; i++) {
            graph.add(List.of(0 , i+1 , wells[i]));
        }

        for(int[] pipe: pipes) {
            graph.add(List.of(pipe[0] , pipe[1] , pipe[2]));
        }

        UnionFind uf = new UnionFind(n+1);

        graph.sort(Comparator.comparingInt(edge -> edge.get(2)));

        int cost = 0;

        for(List<Integer> edge: graph) {
            if(uf.union(edge.get(0) , edge.get(1))) {
                cost += edge.get(2);
            }
        }
        return cost;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i < n ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x , int y) {
        int root_x = find(x);
        int root_y = find(y);

        if(root_x == root_y) {
            return false;
        } else {
            if(rank[root_x] > rank[root_y]) {
                parent[root_y] = root_x;
            } else if(rank[root_x] < rank[root_y]) {
                parent[root_x] = root_y;
            } else {
                parent[root_y] = root_x;
                rank[root_x]++;
            }
            return true;
        }
    }
}
