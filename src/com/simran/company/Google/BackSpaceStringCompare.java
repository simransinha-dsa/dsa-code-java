package com.simran.company.Google;

import java.util.ArrayList;
import java.util.List;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
        
        for(char c: s.toCharArray()) {
            if(c != '#') sList.add(c);
            else {
                if(sList.size() != 0) {
                    sList.remove(sList.size() - 1);
                }
            }
        }
        
        for(char c: t.toCharArray()) {
            if(c != '#') tList.add(c);
            else {
                if(tList.size() != 0) {
                    tList.remove(tList.size() - 1);
                }
            }
        }
        
        return sList.equals(tList);
    }
}
