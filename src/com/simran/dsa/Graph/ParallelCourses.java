package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {
    public static void main(String[] args) {
        int[][] relations = new int[][] {{1 , 2} , {3 , 4}, {4 , 3}};
        System.out.println(minimumSemesters(4, relations));
    }

    public static int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        int count = 0;
        
        for(int[] relation: relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int total = 0;
        for(int i = 0 ; i < n ; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                total++;
            }
        }
        if(queue.isEmpty()) return -1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- != 0) {
                int node = queue.poll();
                for(int neighbor: graph.get(node)) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) {
                        queue.add(neighbor);
                        total++;
                    }
                }
            }
            count++;
        }
        return total == n ? count : -1;
    }
}
