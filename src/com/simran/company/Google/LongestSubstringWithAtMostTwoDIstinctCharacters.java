package com.simran.company.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDIstinctCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithAtMostTwoDIstinctCharacters("ccaabbb"));
    }   

    public static int longestSubstringWithAtMostTwoDIstinctCharacters(String s) {
        Map<Character , Integer> map = new HashMap<>();
        String substring = "";

        int j = 0;
        int maxLength = 0;
        List<Character> substringList = new ArrayList<>();

        while(j < s.length()) {
            char c = s.charAt(j);

            if(map.size() == 2 && !map.containsKey(c)) {
                while(map.size() == 2) {
                    char a = substringList.remove(0);
                    if(map.get(a) == 1) map.remove(a);
                    else map.put(a, map.get(a) - 1);
                }
            }
            substringList.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
            j++;
            if(maxLength < substringList.size()) {
                maxLength = substringList.size();
                substring = getString(substringList);
            }
        }
        System.out.println(substring);
        return maxLength;
    }

    public static String getString(List<Character> list) {
        StringBuilder sb = new StringBuilder();

        for(char ch: list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
