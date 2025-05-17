package com.simran.company.Google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWIthoutRepeatingCharacter {

    // Leetcode - 3
    // Given a string s, find the length of the longest substring without duplicate characters
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        
        int i = 0;
        int j = 0;

        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
                j++;
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
