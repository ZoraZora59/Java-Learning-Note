package com.zora;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h3>Java-Learning-Note</h3>
 * <h4>com.zora</h4>
 * <p>最频繁出现的字母</p>
 *
 * @author : zora
 * @since : 2019/12/05
 */
public class MostFrequencyABC {
    public static void main(String[] args) {
        String value = "abczAbcbbZ";
        Character c = mostFrequentLetter(value);
        System.out.println(c);
    }

    private static int charToAscii(char ch) {
        return  ch;
    }
    private static char asciiToChar(int ascii) {
        return  (char) ascii;
    }

    public static Character mostFrequentLetter(String string) {
        final String regex = "[^a-zA-Z]";
        //滤空
        if(string ==null){
            return null;
        }else {
            string = string.replaceAll(regex,"");
            if (string.isEmpty()) {
                return null;
            }
        }
        char[] chars=string.toCharArray();
        //写入Map
        Map<Integer,Integer> map = new HashMap<>();
        for (char ch : chars) {
            int ascii =charToAscii(ch);
            if(map.containsKey(ascii)){
                map.put(ascii,map.get(ascii)+1);
            }else {
                map.put(ascii,1);
            }
        }
        //顺序取出
        int maxAscii=-1;
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(maxAscii<0){
                maxAscii=entry.getKey();
                maxCount=entry.getValue();
            }else if(entry.getValue()>maxCount){
                if(entry.getKey()>maxAscii){
                    maxAscii=entry.getKey();
                    maxCount=entry.getValue();
                }
            }
        }
        return asciiToChar(maxAscii);
    }
}
