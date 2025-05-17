package com.simran.company.Google;

public class MultiplyStrings {

    // Leetcod - 43
    public static void main(String[] args) {
        System.out.println(multiplyString("123", "456"));
    }

    public static String multiplyString(String s1 , String s2) {
        int n = s1.length();
        int m = s2.length();

        if("0".equals(s1) || "0".equals(s2)) return "0";

        int[] product = new int[n + m];

        for(int i = n-1 ; i >= 0 ; i--) {
            int a = s1.charAt(i) - '0';
            for(int j = m -1 ; j >= 0 ; j--) {
                int b = s2.charAt(j) - '0';
                int index = i + j + 1;
                int p = a * b + product[index];
                product[index] = p % 10;
                product[index - 1] += p / 10;
            }
        }

        int start = product[0] != 0 ? 0 : 1;

        StringBuilder sb = new StringBuilder();

        for(int i = start ; i < product.length ; i++) {
            sb.append(product[i]);
        }

        return  sb.toString();
    }
}
