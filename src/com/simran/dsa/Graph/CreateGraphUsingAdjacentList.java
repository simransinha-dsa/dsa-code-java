package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;

public class CreateGraphUsingAdjacentList {
    
    public static void main(String[] args) {
        List<List<Integer>> graph = createGraphUsingAdjacencyList(4 , new int[][] {{0 , 1} , {0 , 2} , {1 , 2} , {2 , 3}});
        printNeighbor(graph , 2);
    }

    /*
     * Adjaceny list helps to find the neighbour easier.
     */
    public static List<List<Integer>> createGraphUsingAdjacencyList(int n , int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }

    public static void printNeighbor(List<List<Integer>> graph , int node) {
        List<Integer> neighbors = graph.get(node);

        for(int i = 0 ; i < neighbors.size() ; i++) {
            System.err.print(neighbors.get(i) + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> createGraphUsingAdjacencyListDirectedGraph(int n , int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected Graph
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        return graph;
    }
}
