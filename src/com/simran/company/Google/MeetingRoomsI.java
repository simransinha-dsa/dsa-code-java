package com.simran.company.Google;

import java.util.Arrays;

public class MeetingRoomsI {
    // leetcode - 252
    public static void main(String[] args) {
        System.out.println(canAttendMeetingsBruteForce(new int[][] {{0 , 30} , {5 , 10} , {15 , 20}}));
    }

    public static boolean canAttendMeetingsBruteForce(int[][] intervals) {
        for(int i = 0; i < intervals.length - 1; i++) {
            for(int j = i+1 ; j < intervals.length ; j++) {
                if(overlap(intervals[i] , intervals[j])) return false;
            }
        }
        return true;
    }

    public static boolean overlap(int[] interval1 , int[] interval2) {
        int minEnd = Math.min(interval1[1] , interval2[1]);
        int maxStart = Math.max(interval1[0] , interval2[0]);

        return minEnd > maxStart;
    }

    public static boolean canAttendMeetingsOptimal(int[][] intervals) {
        Arrays.sort(intervals , (a ,b) -> Integer.compare(a[0], b[0]));

        for(int i = 0 ; i < intervals.length - 1 ; i++) {
            if(intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}
