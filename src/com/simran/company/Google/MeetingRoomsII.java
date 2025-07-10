package com.simran.company.Google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
   public static void main(String[] args) {
        numberOfMeetingRooms(new int[][] {{9 , 10} , {4 , 9} , {4 , 17}});
   }
   
   public static int numberOfMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
   }
}
