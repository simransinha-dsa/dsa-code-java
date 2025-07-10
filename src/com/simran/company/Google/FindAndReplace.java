package com.simran.company.Google;

public class FindAndReplace {
     // Not working
    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = new int[] {0 , 2};
        String[] sources = new String[] {"ab" , "ec"};
        String[] targets = new String[] {"eee" , "ffff"};
        
        findReplaceString(s, indices, sources, targets);

    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < sources.length ; i++) {
            int index = indices[i];
            int length = sources[i].length();
            String subString = s.substring(index);
            System.out.println(subString);
        }

        return "";
    }
}
