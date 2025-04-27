package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithKStops {
    // There are n cities connected by some number of flights. You are given an array flights 
    // where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
    // You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
    // If there is no such route, return -1.

    // Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
    // Output: 700
    // Explanation:
    // The graph is shown above.
    // The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
    // Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.


    public static void main(String[] args) {
        // [0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]
        // System.out.println(findCheapestPrice(4, new int[][] {{0 ,1 , 100} , {1 , 2 , 100} , {2 , 0 , 100} , {1 , 3 , 600}, {2 , 3, 200}}, 0, 3, 1));
        System.out.println(findCheapestPrice(4, new int[][] {{0 , 1 , 1} , { 0, 2 , 5}, {1 , 2 , 1} , {2 , 3 , 1}}, 0, 3, 1));
    }

    static class Pair {
        int destination;
        int price;

        public Pair(int d , int p) {
            this.destination = d;
            this.price = p;
        }

        
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[n];

        for(int i = 0 ; i < n ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int[] edge: flights) {
            graph.get(edge[0]).add(new Pair(edge[1] , edge[2]));
        }

        distance[src] = 0;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(src , 0));

        int steps = 0;

        while(!queue.isEmpty() && steps <= k) {
            int[] temp = Arrays.copyOf(distance, n);
            int N = queue.size();
            while(N-- != 0) {
                Pair node = queue.remove();
                int curr = node.destination;
                int cost = node.price;
                for(Pair neighbor: graph.get(curr)) {
                    int next = neighbor.destination;
                    int price = neighbor.price;
                    int nextCost = cost + price;
    
                    if(nextCost < distance[next]) {
                        temp[next] = nextCost;
                        queue.add(new Pair(next , nextCost));
                    }
                }
            }
            distance = temp;
            steps++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

    }
}
