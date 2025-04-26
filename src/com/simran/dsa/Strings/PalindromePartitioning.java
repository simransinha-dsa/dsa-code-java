package com.simran.dsa.Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        partition("abbab");
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        palindromePartition(result , s , 0 , new ArrayList<>());

        return result;
    }

    public static void palindromePartition(List<List<String>> result , String s , int start , List<String> temp) {
        if(start == s.length()) {
            result.add(temp);
            return;
        }

        for(int i = start ; i < s.length(); i++) {
            if(isPalindrome(s , start , i)) {
                temp.add(s.substring(start , i+1));
                palindromePartition(result , s, i+1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s , int start , int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
