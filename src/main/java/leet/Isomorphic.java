package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yiwengao on 5/3/15.
 */
public class Isomorphic {
    public static void main(String[] args){
        System.out.println(isIsomorphic("ab", "aa"));
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < s.length(); i++) {

            String sChar = String.valueOf(s.charAt(i));
            String tChar = String.valueOf(t.charAt(i));
            if (sChar.equals(tChar)){
                continue;
            }
            if ( !map.containsKey(tChar)) {
                map.put(tChar, sChar);

            } else if ( map.containsKey(tChar) && !sChar.equals(map.get(tChar))) {
                return false;
            }


        }
        return true;

    }
}
