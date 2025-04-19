package com.simran.company.Amazon;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author simransinha
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeating("pwwkew"));
    }

    public static int longestSubstringWithoutRepeating(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        int j = 0;
        int i = 0;

        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength , (j - i));
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
