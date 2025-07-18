package com.simran.company.Google;

import java.util.Arrays;

public class PlusOne {

    // leetcode = 66
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {9 , 9 , 9})));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n-1 ; i >= 0 ; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[n+1];
        digits[0] = 1;

        return digits;
    }
}
