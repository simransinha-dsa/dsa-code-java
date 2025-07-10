package com.simran.company.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

    // leetcode - 76
    public static void main(String[] args) {
        System.out.println(minimumWindowString("ADOBECODEBANC", "ABC"));
    }

    public static String minimumWindowString(String s , String t) {
        if(t.isEmpty()) return "";

        Map<Character , Integer> map_t = new HashMap<>();
        Map<Character , Integer> window = new HashMap<>();

        for(char c: t.toCharArray()) {
            map_t.put(c , map_t.getOrDefault(c, 0) + 1);
        }

        int r = 0;
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int have = 0;
        int need = map_t.size();
        int[] res = {-1 , -1};

        while(r < s.length()) {
            char a = s.charAt(r);

            window.put(a, window.getOrDefault(a, 0) + 1);

            if(map_t.containsKey(a) && Objects.equals(map_t.get(a), window.get(a))) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < minLength) {
                    minLength = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar , window.getOrDefault(leftChar , 0) - 1);
                if(map_t.containsKey(leftChar) && window.get(leftChar) < map_t.get(leftChar)) {
                    have--;
                }
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0] , res[1] + 1);
    }
}
