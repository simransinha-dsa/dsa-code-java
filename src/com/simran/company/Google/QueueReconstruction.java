package com.simran.company.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {
    public static void main(String[] args) {
        int[][] queue = new int[][] {{7 , 0} , {4 , 4} , {7 , 1} , {5 , 0} , {6 , 1} ,{5 , 2}};

        reconstructQueue(queue);
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people , (a,b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        // input = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
       // output = [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

       // sorted input = [[7 , 0] , [7 , 1] , [6,1] , [5 , 0], [5 , 2], [4 ,4]]
       // [[5 , 0], [7 , 0] , [5 , 2] , [6 , 1] , [4 , 4] , [7 , 1]]


        List<List<Integer>> result = new ArrayList<>();

        for(int[] person: people) {
            result.add(person[1] , List.of(person[0] , person[1]));
        }

        for(int i = 0 ; i < result.size(); i++) {
            people[i][0] = result.get(i).get(0);
            people[i][1] = result.get(i).get(1);
        }

        return people;
    }
}
