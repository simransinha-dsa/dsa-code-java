package com.simran.company.Google;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][] {{'o' , 'a' , 'a' , 'n'} , {'e' , 't' , 'a' , 'e'} , {'i' , 'h' , 'k' , 'r'} , {'i' , 'f' , 'l' , 'v'}}, "eat"));
        List<String> result = exist2(new char[][] {{'o' , 'a' , 'a' , 'n'} , {'e' , 't' , 'a' , 'e'} , {'i' , 'h' , 'k' , 'r'} , {'i' , 'f' , 'l' , 'v'}}, new String[] {"oath" , "pea" , "eat" , "rain"});
        for(String str: result) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
    public static boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == word.charAt(0) && findWord(i , j , board , word , 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findWord(int i , int j , char[][] board , String word , int index) {
        if(index >= word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) 
            return false;
        
        char temp = board[i][j];
        board[i][j] = '$';
        
        if(findWord(i+1 , j , board , word , index+1)) {
            board[i][j] = temp;
            return true;
        }
        if(findWord(i-1 , j , board , word , index+1)) {
            board[i][j] = temp;
            return true;
        }
        if(findWord(i , j+1 , board , word , index+1)) {
            board[i][j] = temp;
            return true;
        }
        if(findWord(i , j-1 , board , word , index+1)) {
            board[i][j] = temp;
            return true;
        }
        
        board[i][j] = temp;
        
        return false;
    }

    public static List<String> exist2(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for(String word: words) { 
            if(exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    class Solution {
        int[][] directions = new int[][] {{0,1} , {0,-1} , {1,0} , {-1,0}};
        int m, n;
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
    
            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(board[i][i] == word.charAt(0) && find(i , j , 0 , word , board)) {
                       return true;
                    }
                }
            }
            return false;
        }
    
        public boolean find(int i , int j, int index , String word, char[][] board) {
            if(index >= word.length()) return true;
    
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index)) {
                return false;
            }
    
            char temp = board[i][j];
            board[i][j] = '$';
    
            if(find(i+1 , j , index+1 , word , board)) return true;
            if(find(i-1 , j , index+1 , word , board)) return true;
            if(find(i , j+1 , index+1 , word , board)) return true;
            if(find(i , j-1 , index+1 , word , board)) return true;
            board[i][j] = temp;
            return false;
        }
    }
    
}
