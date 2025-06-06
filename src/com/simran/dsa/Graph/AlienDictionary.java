package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(alienOrder(new String[] {"ac","ab","zc","zb"}));
    }

    public static String alienOrder(String[] words) {
        Map<Character , List<Character>> adjList = new HashMap<>();
        Map<Character , Integer> counts = new HashMap<>(); // indegree

        for(String word: words) {
            for(char c: word.toCharArray()) {
                counts.put(c , 0);
                adjList.put(c , new ArrayList<>());
            }
        }

        // Step 1. Find All Edges
        for(int i = 0 ; i < words.length - 1 ; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Check that word2 is not a prefix of word1.
            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for(int j = 0 ; j < Math.min(word1.length() , word2.length()) ; j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j) , counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for(Character c: counts.keySet()) {
            if(counts.get(c).equals(0)) {
                queue.add(c);
            }
        }

        while(!queue.isEmpty()) {
            Character node = queue.poll();
            sb.append(node);
            for(Character next: adjList.get(node)) {
                counts.put(next, counts.get(next) - 1);
                if(counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if(sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
