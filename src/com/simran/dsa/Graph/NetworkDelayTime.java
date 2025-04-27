package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkDelayTime {

    public static void main(String[] args) {
        // [2,1,1],[2,3,1],[3,4,1]
       networkDelayTime(new int[][] {{2 ,1 , 1} , {2 ,3 ,1} , {3 ,4 ,1 }}, 4, 2);
    }
    static class Pair implements Comparable<Pair> {
        int next;
        int time;

        Pair(int n , int t) {
            this.next = n;
            this.time = t;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.time , other.time);
        }
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] time: times) {
            graph.get(time[0] - 1).add(new Pair(time[1] - 1 , time[2]));
        }

        int[] distance = new int[n];
        Arrays.fill(distance , Integer.MAX_VALUE);

        distance[k - 1] = 0;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(k - 1 , 0));

        boolean[] visited = new boolean[n];

        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            int curr = node.next;
            if(visited[curr]) continue;;
            visited[curr] = true;

            for(Pair neighbor: graph.get(curr)) {
                int next = neighbor.next;
                int time = neighbor.time;
                if(distance[curr] + time < distance[next]) {
                    distance[next] = distance[curr] + time;
                }
                queue.add(new Pair(next , distance[next]));
            }
        }

        return distance[n-1] == Integer.MAX_VALUE ? -1 : distance[n-1];
    }
}
