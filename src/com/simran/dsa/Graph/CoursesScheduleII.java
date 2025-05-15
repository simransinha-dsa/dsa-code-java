package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CoursesScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrderBFS(2, new int[][] {{1 , 0}})));
    }

    static boolean hasCycle = false;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] course: prerequisites) {
            graph.get(course[1]).add(course[0]);
        }

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        for(int i = 0 ; i < numCourses; i++) {
            if(!visited[i]) {
                dfs(graph , i , stack , visited , recursionStack);
            }
        }
        if(!hasCycle) {
           int i = 0;
            while(!stack.isEmpty()) {
                courses[i++] = stack.pop();
            } 
        } else {
            return new int[0];
        }

        return courses;
    }

    public static void dfs(List<List<Integer>> graph , int curr , Stack<Integer> stack , boolean[] vis , boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;

        for(int node: graph.get(curr)) {
            if(rec[node]) {
                hasCycle = true;
                return;
            }

            if(!vis[node]) {
                dfs(graph , node , stack , vis , rec);
            }
        }

        stack.push(curr);
        rec[curr] = false;
    }

    public static int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for(int i = 0 ; i < numCourses ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] course: prerequisites) {
            graph.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }
        
        return topologicalSort(numCourses , graph , indegree);
    }
    
    public static int[] topologicalSort(int n , List<List<Integer>> graph , int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        int[] result = new int[n];
        int j = 0;
        
        for(int i = 0 ; i < n ; i++) {
            if(indegree[i] == 0) {
                result[j++] = i;
                queue.add(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor: graph.get(node)) {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0) {
                    count++;
                    result[j++] = neighbor;
                    queue.add(neighbor);
                }
            }
        }
        if(count != n) {
            return new int[0];
        } else {
            return result;
        }
    }
}
