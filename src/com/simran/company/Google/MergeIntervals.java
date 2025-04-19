/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.company.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author simransinha
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][] {{1 , 3} , {2 , 6} , {8 , 10} , {15 , 18}};
        int[][] result = merge(input);
        for(int[] interval: result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0] , b[0]));

        int i = 0;

        while(i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;

            while(i < intervals.length && end >= intervals[i][0]) {
                end = Math.max(end , intervals[i][1]);
                i++;
            }

            int[] temp = new int[2];
            temp[0] = start;
            temp[1] = end;

            result.add(temp);
        }

        return result.toArray(new int[result.size()][]);
        
    }
}
