/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.simran.company.Amazon;

/**
 *
 * @author simransinha
 */
public class BestTimeToBuySell {
     /*
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */

     public static void main(String[] args) {
        System.out.println(maxProfitBruteForce(new int[] {7,6 ,5 , 4 , 3 , 2}));
        System.out.println(maxProfitOptimalI(new int[] {7,6 ,5 , 4 , 3 , 2}));
        System.out.println(maxProfitOptimalII(new int[] {7,6 ,5 , 4 , 3 , 2}));
     }

     // Brute Force
     // O(n2)

    public static int maxProfitBruteForce(int[] prices) {
        // This will give time limit exceeded issue on leetcode
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length ; i++) {
            for(int j = i+1 ; j < prices.length ; j++) {
                int diff = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit , diff);
            }
        }
        return maxProfit >= 0 ? maxProfit : 0;
    }

     // Optimal I
     // Space O(n)
     // Time O(n)

    public static int maxProfitOptimalI(int[] prices) {
        int[] minPrices = new int[prices.length];
        int[] maxPrices = new int[prices.length];
        minPrices[0] = prices[0];
        maxPrices[prices.length - 1] = prices[prices.length - 1];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            minPrices[i] = Math.min(minPrices[i-1], prices[i]);
        }
        for(int j = prices.length - 2; j >= 0 ; j--) {
            maxPrices[j] = Math.max(maxPrices[j+1] , prices[j]);
        }
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxPrices[i] - minPrices[i]);
        }
        return maxProfit >= 0 ? maxProfit : 0;
    }

    // Optimal I
    // Time O(n)

    public static int maxProfitOptimalII(int[] prices) {
        // Kadane algorithm 
        // maintain current sum and a global max sum
        int buy = prices[0];
        int maxProfit = 0;
        for(int i = 1 ; i < prices.length; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit , (prices[i] - buy));
        }
        return maxProfit;
    }
}
