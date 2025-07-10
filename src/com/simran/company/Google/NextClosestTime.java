package com.simran.company.Google;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public static void main(String[] args) {
        System.out.println(nextClosestTime("19:34"));
    }

    public static String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();

        for(char c: time.toCharArray()) {
            if(c != ':') {
                set.add(c);
            }
        }

        int currentMinutes = toMinutes(time);
        String result = time;
        int minDiff = Integer.MAX_VALUE;

        for(char h1: set) {
            for(char h2: set) {
                for(char m1: set) {
                    for(char m2: set) {
                       String nextTime = "" + h1 + h2 + ":" + m1 + m2;
                       if(isValidTime(nextTime)) {
                            int nextMinutes = toMinutes(nextTime);
                            int diff = (nextMinutes - currentMinutes + 1440) % 1440; // to not have negative number , adding total number of 
                            // minutes for a day 24 * 60 and moduling to get the exact diff in minute
                            if(diff > 0 && diff < minDiff) { // checking diff > 0 to neglect diff = 0 case which is the case of same time as input
                                minDiff = diff;
                                result = nextTime;
                            }
                       }
                    }
                }
            }
        }

        return result;
    }

    public static int toMinutes(String time) {
        int minutes = 60 * Integer.parseInt(time.substring(0 , 2));
        minutes += Integer.parseInt(time.substring(3));

        return minutes;
    }

    public static boolean isValidTime(String time) {
        int hour = Integer.parseInt(time.substring(0 , 2));
        int minutes = Integer.parseInt(time.substring(3));

        return hour < 24 && minutes < 60;
    }
}
