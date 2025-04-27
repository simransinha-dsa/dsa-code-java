package com.simran.dsa.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] {{2 , 1 , 1} , {1 , 1 , 0} , {0 , 1 , 1}}));
        System.out.println(orangesRotting(new int[][] {{0}}));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 2) {
                    Node node = new Node(0 , i , j);
                    queue.add(node);
                }
            }
        }
        Node rottenOranges = null;

        while(!queue.isEmpty()) {
            rottenOranges = queue.poll();
            int time = rottenOranges.time;
            int x = rottenOranges.x;
            int y = rottenOranges.y;

            if(x != 0 && grid[x-1][y] == 1) {
                grid[x-1][y] = 2;
                Node orange = new Node(time + 1 , x-1 , y);
                queue.add(orange);
            }

            if(y != grid[x].length - 1 && grid[x][y+1] == 1) {
                grid[x][y+1] = 2;
                Node orange = new Node(time + 1 , x , y+1);
                queue.add(orange); 
            }

            if(x != grid.length - 1 && grid[x+1][y] == 1) {
                grid[x+1][y] = 2;
                Node orange = new Node(time + 1 , x+1 , y);
                queue.add(orange);
            }

            if(y != 0 && grid[x][y-1] == 1) {
                grid[x][y-1] = 2;
                Node orange = new Node(time + 1, x, y-1);
                queue.add(orange);
            }
        }

        for (int[] grid1 : grid) {
            for (int j = 0; j < grid1.length; j++) {
                if (grid1[j] == 1) {
                    return -1;
                }
            }
        }

        return rottenOranges != null ? rottenOranges.time : 0;
    }
}
