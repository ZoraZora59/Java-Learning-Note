package com.zora;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * LeetCode https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Longest Substring Without Repeating Characters
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * @author Zora
 */
public class LongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input String ：");
        String str = scanner.nextLine();
        System.out.println("Longest substring length ：" + new LongestSubstring().lengthOfLongestSubstring(str));
    }
    private int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        LinkedList son=new LinkedList();
        int maxCount=0;
        char index;
        for (int i = 0; i < s.length(); i++) {
            index=s.charAt(i);
            if(!son.contains(index)){
                son.add(index);
            }else {
                if(maxCount<son.size()){
                    maxCount=son.size();
                }
                while(!son.getFirst().equals(index)){
                    son.pop();
                }
                son.pop();
                son.add(index);
            }
        }
        if(maxCount<son.size()){
            maxCount=son.size();
        }
        return maxCount;
    }
}
