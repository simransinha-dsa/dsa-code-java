package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(List.of("JFK","SFO")));
        graph.add(new ArrayList<>(List.of("JFK","ATL")));
        graph.add(new ArrayList<>(List.of("SFO","ATL")));
        graph.add(new ArrayList<>(List.of("ATL","JFK")));
        graph.add(new ArrayList<>(List.of("ATL","SFO")));
        findItinerary(graph);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String , List<String>> flightMap = new HashMap<>();
        Map<String , Boolean> visited = new HashMap<>();
        
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if(!flightMap.containsKey(from)) {
                flightMap.put(from , new ArrayList<>());
                visited.put(from , false);
            }
            flightMap.get(from).add(to);
        }
        
        for (List<String> destinations : flightMap.values()) {
            Collections.sort(destinations , Collections.reverseOrder());
        }
        
        List<String> results = new ArrayList<>();
        
        Stack<String> stack = new Stack();
        
        stack.push("JFK");
        // visited.put("JFK" , true);
        
        while(!stack.isEmpty()) {
            String node = stack.pop();
            results.add(node);
            
            if(visited.containsKey(node) && !visited.get(node)) {
                List<String> neighbors = flightMap.get(node);
                if(neighbors != null) {
                    for(String neighbor: neighbors) {
                        stack.push(neighbor);
                    }
                }
            }

            visited.put(node , true);
        }
        
        return results;
    }
}
