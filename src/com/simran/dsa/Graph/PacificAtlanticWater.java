package com.simran.dsa.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWater {
    public static void main(String[] args) {
        List<List<Integer>> result = pacificAtlantic(new int[][] {{1,2,2,3,5} , {3,2,3,4,4} , {2,4,5,3,1} , {6,7,1,4,5}, {5,1,1,2,4}});

        for(List<Integer> list: result) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static  List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0 ; i < m ; i++) {
            dfs(0 , i , heights[0][i] , pacific , heights);
            dfs(m-1 , i , heights[m-1][i] , atlantic , heights);
        }

        for(int j = 0 ; j < n ; j++) {
            dfs(j , 0 , heights[j][0] , pacific , heights);
            dfs(j , n - 1, heights[j][n-1] , atlantic , heights);
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i , j));
                }
            }
        }

        return result;
    }

    public static void dfs(int i , int j , int preVal , boolean[][] visited , int[][] heights) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j] || heights[i][j] < preVal) {
            return;
        }

        visited[i][j] = true;

        dfs(i - 1 , j , heights[i][j] , visited , heights);
        dfs(i + 1 , j , heights[i][j] , visited , heights);
        dfs(i , j - 1 , heights[i][j] , visited , heights);
        dfs(i , j + 1 , heights[i][j] , visited , heights);
    }
}
