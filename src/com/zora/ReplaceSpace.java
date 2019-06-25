package com.zora;

import java.util.Scanner;

/**
 * 替换空格
 * 来源：AcWing
 * 题目描述
 * 请实现一个函数，把字符串中的每个空格替换成 "%20"。
 * 你可以假定输入字符串的长度最大是 1000。 注意输出字符串的长度可能大于 1000。
 * 样例
 * 输入："We are happy."
 * 输出："We%20are%20happy."
 *
 * @author Zora
 *
 * 实测该方法运行时比replaceall方法快50%
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        /*
        输入数据
        Scanner scanner=new Scanner(System.in);
        StringBuffer stringBuffer=new StringBuffer(scanner.nextLine());*/
        StringBuffer stringBuffer = new StringBuffer("Dear Crystal, I'm so sorry to hear that life is getting you down at the moment. Goodness knows, it can be so tough when nothing seems to fit and little seems to be fulfilling. I'm not sure there's any specific advice I can give that will help bring life back its savour. Although they mean well, it's sometimes quite galling to be reminded how much people love you when you don't love yourself that much.  I've found that it's of some help to think of one's moods and feelings about the world as being similar to weather : Here are some obvious things about the weather: It's real.  You can't change it by wishing it away.  If it's dark and rainy it really is dark and rainy and you can't alter it.  It might be dark and rainy for two weeks in a row.  It will be sunny one day. It isn't under one's control as to when the sun comes out, but come out it will.  One day.  It really is the same with one's moods, I think. The wrong approach is to believe that they are illusions. They are real. Depression, anxiety, listlessness - these are as real as the weather - AND EQUALLY NOT UNDER ONE'S CONTROL. Not one's fault.   BUT  They will pass: they really will. In the same way that one has to accept the weather, so one has to accept how one feels about life sometimes. \"Today's a crap day,\" is a perfectly realistic approach. It's all about finding a kind of mental umbrella. \"Hey-ho, it's raining inside: it isn't my fault and there's nothing I can do about it, but sit it out. But the sun may well come out tomorrow and when it does, I shall take full advantage.\" I don't know if any of that is of any use: it may not seem it, and if so, I'm sorry. I just thought I'd drop you a line to wish you well in your search to find a little more pleasure and purpose in life.  Very best wishes. (Signed) Stephen Fry");

        //获取开始时间
        long startTime = System.nanoTime();

        System.out.println("Replace Finished:" + replaceSpaces(stringBuffer));

        //获取结束时间
        long endTime = System.nanoTime();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    private static String replaceSpaces(StringBuffer str) {
        if (null == str) {
            return null;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (' ' == str.charAt(i)) {
                str.append("NN");
            }
        }
        char ch;
        for (int i = len - 1, j = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            if (' ' == ch) {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, ch);
            }
        }
        return str.toString();
    }
}
