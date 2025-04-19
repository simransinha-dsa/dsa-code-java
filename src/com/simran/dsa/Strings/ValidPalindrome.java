/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.dsa.Strings;

/**
 *
 * @author simransinha
 */
public class ValidPalindrome{

    public static void main(String[] args) {
        System.out.println(isValidPalindromeI("A man, a plan, a canal: Panama"));
        System.out.println(isValidPalindromeI("race a car"));
    }

    // Brute Force
    // O(n)

    public static  boolean isValidPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        String reversed = sb.reverse().toString();

        return (reversed == null ? s == null : reversed.equals(s));
    }

    // optimal - Two Pointers
    // O(n)

    public static boolean isValidPalindromeI(String s) {
        if(s.isEmpty() || " ".equals(s)) return true;
        int i = 0 ; 
        int j = s.length() - 1;

        while(i <= j) {
            while(i <= j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i <= j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if(i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
