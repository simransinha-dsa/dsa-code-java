/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.dsa.Strings;

import java.util.Arrays;

/**
 *
 * @author simransinha
 */
public class PermutationInString {

    /*
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     * In other words, return true if one of s1's permutations is the substring of s2.
     */

     public static void main(String[] args) {
         System.out.println(isPermutationPresent("ab", "eidbaooo"));
     }

     public static  boolean isPermutationPresent(String s , String t) {
        
        int[] s_fre = new int[26];

        int length = s.length();

        for(char c: s.toCharArray()) {
            s_fre[c - 'a']++;
        }

        for(int i = 0 ; i < t.length() ; i++) {
            int windowIndex = 0;
            int index = i;
            int[] t_fre = new int[26];
            while(windowIndex < length && index < t.length()) {
                t_fre[t.charAt(index++) - 'a']++;
                windowIndex++;
            }

            if(Arrays.equals(t_fre, s_fre)) return true;
        }

        return false;
     }
}
