/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author simransinha
 */
public class SingleElement{
    public static void main(String[] args) {
        System.out.println(singleNumberXor(new int[] {4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer , Integer> fre = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            fre.put(nums[i] , fre.getOrDefault(nums[i] , 0) + 1);
        }

        for(Map.Entry<Integer , Integer> map: fre.entrySet()) {
            if(map.getValue() == 1) return map.getKey();
        }

        return -1;
    }


    public static int singleNumberXor(int[] nums) {
        int val = nums[0];

        for(int i = 1 ; i < nums.length; i++) {
            val ^= nums[i];
        }

        return val;
    }
}
