package com.simran.company.Google;

public class ExpressiveWord {
    public static void main(String[] args) {
        // Not working
        System.out.println(expressiveWords("aaa", new String[] {"aaaa"}));
    }

    public static int expressiveWords(String s, String[] words) {
        int count = 0;
        
        boolean extensible = false;

        for(String word: words) {
            int i = 0;
            int j = 0;
            if(word.length() > s.length()) break;
            while(i < s.length() && j < word.length()) {
                if(s.charAt(i) == word.charAt(j)) {
                    int countOfS = count(s.charAt(i) , s , i+1);
                    int countOfW = count(word.charAt(j) , word , j+1);
                    if(countOfS == countOfW) {
                        extensible = true;
                    } else {
                        extensible = !(countOfS - countOfW == 1 && countOfW == 1);
                        if(!extensible) break;
                    }
                    i = i + countOfS;
                    j = j + countOfW;
                } else {
                    extensible = false;
                    break;
                }
            }
            if(extensible && i == s.length()) count++;
        }
        
        return count;
    }

    public static int count(char c , String s , int index) {
        int count = 1;
        while(index < s.length()) {
            if(c == s.charAt(index)) {
                count++;
            } else {
                break;
            }
            index++;
        }
        return count;
    }
}
