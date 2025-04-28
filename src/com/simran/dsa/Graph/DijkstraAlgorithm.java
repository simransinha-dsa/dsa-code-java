package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    static class Pair implements  Comparable<Pair>{
        int node;
        int distance;

        Pair(int n , int d) {
            this.node = n;
            this.distance = d;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distance , other.distance);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(List.of(1 , 3));
        graph.add(List.of(0 , 2));
        graph.add(List.of(1 , 6));
        graph.add(List.of(0 , 4));
        graph.add(List.of(3 , 5));
        graph.add(List.of(4 , 6));
        graph.add(List.of(2 , 5 , 7 , 8));
        graph.add(List.of(6 , 8));
        graph.add(List.of(7 , 6));
        // {{1 , 3} , {0 , 2} , {1, 6} , {0,4} , {3 ,5} , {4 ,6}, {2 , 5 , 7 , 8}, {6,8}, {7,6}};
        shortedPathInUndirectedGraph(graph, 0);
    }

    public static void shortedPathInUndirectedGraph(List<List<Integer>> graph , int src) {
        // weight of all edge is 1
        int n = graph.size();

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src , 0));

        distance[src] = 0;

        while(!pq.isEmpty()) {
            // get the shortest distance element
            Pair node = pq.remove();
            int curr = node.node;
            if(visited[curr]) continue;
            visited[curr] = true;

            // update the distance for its neighbor
            for(int i = 0 ; i < graph.get(curr).size(); i++) {
                int neighbor = graph.get(curr).get(i);
                if(!visited[neighbor]) {
                    if(distance[curr] + 1 < distance[neighbor]) {
                        distance[neighbor] = distance[curr] + 1;
                        pq.add(new Pair(neighbor , distance[neighbor]));
                    }
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
            System.out.print(distance[i] + " ");
        }

        System.out.println();
    }
}
