package com.simran.company.Microsoft;

import java.util.HashSet;
import java.util.Set;

public class SetZerosMatrix {
    public static void main(String[] args) {
        
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(row.contains(i)) {
                    matrix[i][j] = 0;
                } else if(!row.contains(i) && column.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
