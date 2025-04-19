/**
 *
 * @author simransinha
 */

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    
    public static void main(String[] args) {
        System.out.println("Input List of String: " + "neet, code, love, you");
        String encoded = encode(List.of("neet","code","love","you"));
        List<String> decoded = decode(encoded);
        System.out.print("Output List of String: ");
        for(String str: decoded) {
            System.out.print(str + ", " );
        }
        System.out.println();
    }

    public static String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String str: strs) {
            sizes.add(str.length());
        }
        for(int size: sizes) {
            res.append(size).append(',');
        }

        res.append('#');

        for(String str: strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while(str.charAt(i) != '#') {
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i) != ',') {
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.valueOf(curr.toString()));
            i++;
        }

        i++; // to go to the string character
        for(int size: sizes) {
            res.add(str.substring(i, i + size));
            i += size;
        }
        return res;
    }
}
