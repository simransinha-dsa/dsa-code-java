package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    public static void main(String[] args) {
        List<Integer> result = eventualSafeNodes(new int[][] {{} , {0 , 2 , 3 , 4} , {3} , {4} , {}});

        for(int node: result) {
            System.out.print(node + " ");
        }

        System.out.println();
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        // stack array will tell which node has a cycle or not, if true has cycle else not
        // you can only reach to terminal node from one node if it does not have a cycle
        List<Integer> safeNodes = new ArrayList<>();

        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];

         for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                isCycle(graph , visited , stack , i);
            }
         }

         for(int i = 0 ; i < n ; i++) {
            if(!stack[i]) {
                safeNodes.add(i);
            }
         }

        return safeNodes;
    }

    public static boolean isCycle(int[][] graph , boolean[] vis , boolean[] stack , int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0 ; i < graph[curr].length ; i++) {
            int node = graph[curr][i];
            if(stack[node]) {
                return true;
            } else if(!vis[node]) {
                if(isCycle(graph , vis , stack , node)) {
                    return true;
                }
            }
        }

        stack[curr] = false;

        return false;
    }
}
