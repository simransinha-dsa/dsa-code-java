package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsLeadToDestination {
    enum Color {WHITE , GRAY , BLACK};

    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Color[] state = new Color[n];

        Arrays.fill(state , Color.WHITE);

        return leadsToDes(source , destination , graph , state);
    }

    public static boolean leadsToDes(int node , int des , List<List<Integer>> graph , Color[] state) {
        if(state[node] != Color.WHITE) {
            return state[node] == Color.BLACK;
        }
        if(graph.get(node).isEmpty()) {
            return node == des;
        }

        state[node] = Color.GRAY;

        for(int neighbor: graph.get(node)) {
            boolean reached = leadsToDes(neighbor, des, graph, state);
            if(!reached) return false;
        }
        state[node] = Color.BLACK;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(leadsToDestination(9 , new int[][] {{0 , 1} , {0 , 2} , {1 , 4} , {2 , 3} , {3 , 4} , {4, 5} , {4 , 6} , {5 , 8} , {6 , 7} ,{7, 8}} , 0 , 8));
    }
}
