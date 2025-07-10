package com.simran.company.Google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class MinimumCostToHireKWorkers {

    public static void main(String[] args) {
        int[] quality = new int[] {3,1,10,10,1};
        int[] wage = new int[] {4,8,2,2,7};
        int k = 3;
        mincostToHireWorkers(quality, wage, k);
    }
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        Pair[] ratioArray = new Pair[n];

        for(int i = 0 ; i < n ; i++) {
            double ratio = (double) wage[i] / quality[i];
            ratioArray[i] = new Pair(ratio , quality[i]);
        }

        Arrays.sort(ratioArray);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        double sum_quality = 0;
        for(int i = 0 ; i < k ; i++) {
            pq.add(ratioArray[i].quality);
            sum_quality += ratioArray[i].quality;
        }

        double managerRatio = ratioArray[k - 1].ratio;
        double result = managerRatio * sum_quality;

        for(int i = k ; i < n ; i++) {
            double manager_ratio = ratioArray[i].ratio;

            pq.add(ratioArray[i].quality);
            sum_quality += ratioArray[i].quality;

            if(pq.size() > k) {
                sum_quality -= pq.poll();
            }

            result = Math.min(result , manager_ratio * sum_quality);
        }

        return result;
    }
}

class Pair implements Comparable<Pair> {
    double ratio;
    int quality;

    Pair(double r , int q) {
        this.ratio = r;
        this.quality = q;
    }

    @Override
    public int compareTo(Pair other) {
        return Double.compare(this.ratio , other.ratio);
    }

    @Override
    public String toString() {
        return "(" + ratio + ", " + quality + ")";
    }
}
