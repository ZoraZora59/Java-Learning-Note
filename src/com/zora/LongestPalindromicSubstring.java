package com.zora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String string = "ab";
        System.out.println("Input : " + string);
        string = new LongestPalindromicSubstring().longestPalindrome(string);
        System.out.println("Output : " + string);
    }
    private String longestPalindrome(String s) {
        if (s == null || " ".equals(s) || "".equals(s)) {
            return "";
        } else if (s.length() < 2) {
            return s;
        }
        HashMap<Character, Integer> map=new HashMap<>(1000);
        char[] str = s.toCharArray();
        int p1=0,p2=str.length-1;
        for (int i=p1;i<=p2;i++) {
            if(!map.containsKey(str[i])){
                map.put(str[i],i);
            }
        }
        int max=0;
        char ch=str[0];
        for(int i=p2;i>=p1;i--){
            if((i-map.get(str[i]))>max){
                ch=str[i];
                max=i-map.get(str[i]);
            }
        }
        String ret="";
        for(int i=map.get(ch),j=0;j<=max;i++,j++){
            ret=ret+str[i];
        }
        return ret;
    }
}
