package com.simran.company.Google;

public class RotateImage {
    // leetcode - 48
    public static void main(String[] args) {
        rotateImage(new int[][] {{1 ,2 , 3} , {4 , 5 , 6} , {7 , 8 , 9}});
    }


    public static void rotateImage(int[][] matrix) {
        int n = matrix.length;
        System.out.println("Input Matrix");
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        

        // Transpose the matrix
        for(int i = 0 ; i < n - 1; i++) {
            for(int j = i+1 ; j < n ; j++) {
                swap(matrix , i , j);
            }
        }

        // now reverse the elements in each row

        for(int i = 0 ; i < n ; i++) {
            int start = 0;
            int end = n - 1;

            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
        System.out.println("Output Matrix");
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[][] grid , int i , int j) {
        int temp = grid[i][j];
        grid[i][j] = grid[j][i];
        grid[j][i] = temp;
    }
}
