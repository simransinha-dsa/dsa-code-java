/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.dsa.Strings;

/**
 *
 * @author simransinha
 */
public class RemoveAllOccurrences {
    
    public static void main(String[] args) {
        System.out.println(removeAllOccurrences("aabababa", "aba"));
    }

    public static String removeAllOccurrences(String s , String t) {
        
        while(s.contains(t)) {
            s = s.replaceFirst(t, "");
        }
        return s;
    }
}
