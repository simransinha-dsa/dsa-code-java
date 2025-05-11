package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    public static void main(String[] args) {
        System.out.println(minimumCost(4, new int[][] {{1 , 2 , 3} , {3 , 4 , 4}}));
    }
    public static int minimumCost(int n, int[][] connections) {
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        heap.add(new Pair(0 , 0));
        int cost = 0;

        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] connection: connections) {
            graph.get(connection[0] - 1).add(new Pair(connection[1] - 1 , connection[2]));
            graph.get(connection[1] - 1).add(new Pair(connection[0] - 1, connection[2]));
        }

        while(!heap.isEmpty()) {
            Pair p = heap.poll();
            int wt = p.weight;
            int node = p.node;

            if(!visited[node]) {
                cost += wt;
                visited[node] = true;
                for(Pair neighbor: graph.get(node)) {
                    int neigh_node = neighbor.node;
                    int neigh_wt = neighbor.weight;
                    if(!visited[neigh_node]) {
                        heap.add(new Pair(neigh_node , neigh_wt));
                    }
                }
            }
        }
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) return -1;
        }
        return cost;
    }
}

class Pair implements Comparable<Pair> {
    int node;
    int weight;

    public Pair(int n , int w) {
        this.node = n;
        this.weight = w;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.weight, other.weight); // Ascending order
    }
}
