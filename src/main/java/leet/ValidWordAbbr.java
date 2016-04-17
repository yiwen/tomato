package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ygao on 3/29/16.
 */
public class ValidWordAbbr {
    public ValidWordAbbr(String[] dictionary) {

    }


    public boolean isUnique(String[] dictionary, String word) {
        if (dictionary==null || dictionary.length==0){
            return true;
        }
        Map<String, String> abbrMap = new HashMap<String, String>();
        for (int i=0;i<dictionary.length ; i++){
            String abbr = getAbbr(dictionary[i]);
            abbrMap.put(abbr ,"1");
        }
        String wordAbbr = getAbbr(word);
        return abbrMap.containsKey(wordAbbr);

    }

    String getAbbr(String word){
        if (word==null || word.length()==0){
            return "";
        }

        if (word.length()<3){
            return word;
        }
        return String.valueOf(word.charAt(0)) + (word.length()-2) + String.valueOf(word.charAt(word.length() - 1));
    }
}
