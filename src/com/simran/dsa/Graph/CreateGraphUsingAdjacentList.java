package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;

public class CreateGraphUsingAdjacentList {
    
    public static void main(String[] args) {
        List<List<Edge>> graph = createGraphUsingAdjacencyList(4);
        printNeighbor(graph , 2);
    }

    /*
     * Adjaceny list helps to find the neighbour easier.
     */
    public static List<List<Edge>> createGraphUsingAdjacencyList(int n) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 2));
        graph.get(1).add(new Edge(1, 2));
        graph.get(1).add(new Edge(1, 3));
        graph.get(2).add(new Edge(2, 0));
        graph.get(2).add(new Edge(2, 1));
        graph.get(2).add(new Edge(2, 3));
        graph.get(3).add(new Edge(3, 1));
        graph.get(3).add(new Edge(3, 2));
        return graph;
    }

    public static void printNeighbor(List<List<Edge>> graph , int node) {
        List<Edge> neighbors = graph.get(node);

        for(int i = 0 ; i < neighbors.size() ; i++) {
            System.err.print(neighbors.get(i).destination + " ");
        }
        System.out.println();
    }
}
