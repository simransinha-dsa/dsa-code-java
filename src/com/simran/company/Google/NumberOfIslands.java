package com.simran.company.Google;

public class NumberOfIslands {
    
    public static void main(String[] args) {
        System.out.println(numberOfIslands(new char[][] {{'1' , '1' , '0' , '0' , '0'} , {'1' , '1' , '0' , '0' , '0'}, {'0' , '0' , '1' , '0' , '0'}, {'0' , '0' , '0' , '1' , '1'}}));
    }

    public static int numberOfIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid , i , j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid , int i , int j) {
        if(i < 0 || j <  0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '*';

        dfs(grid , i+1 , j);
        dfs(grid , i-1 , j);
        dfs(grid , i , j-1);
        dfs(grid , i , j+1);
    }
}
