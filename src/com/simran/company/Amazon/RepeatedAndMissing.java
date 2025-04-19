/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.company.Amazon;

import java.util.Arrays;

/**
 *
 * @author simransinha
 */
public class RepeatedAndMissing {

    public static void main(String[] args) {
        int[] res = findMissingAndRepeatedValues(new int[][] {{1 , 3} , {2 , 2}});
        System.out.println(Arrays.toString(res));
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        int[] fre = new int[n*n + 1];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                fre[grid[i][j]]++;
            }
        }
        int[] res = new int[2];
        for(int i = 1 ; i <= n * n ; i++) {
            if(fre[i] == 2) res[0] = i;
            if(fre[i] == 0) res[1] = i; 
        }

        return res;
    }

}
