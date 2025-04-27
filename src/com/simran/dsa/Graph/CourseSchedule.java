package com.simran.dsa.Graph;

import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] {{1 ,0} , {0 , 1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // to find whether courses can be finished or not 
        // we need to find cycle in a directed graph

        List<List<Integer>> graph = CreateGraphUsingAdjacentList.createGraphUsingAdjacencyListDirectedGraph(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++) {
            if(!visited[i]) {
                if(isCycle(graph , visited , recStack , i)) {
                    return false; // if cycle , courses can not be finished so return false;
                }
            }
        }

        return true; // as we will reach here only if there is no cycle and hence courses can be finished
    }

    public static boolean isCycle(List<List<Integer>> graph , boolean[] vis , boolean[] stack , int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0 ; i < graph.get(curr).size(); i++) {
            int node = graph.get(curr).get(i);
            if(stack[node]) {
                return true;
            } else if(!vis[node]) {
                if(isCycle(graph, vis, stack, node)) {
                    return true;
                }
            }
        }
        return false;
    }
}
