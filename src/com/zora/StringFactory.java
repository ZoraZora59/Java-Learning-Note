package com.zora;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>String学习</p>
 *
 * @author : zora
 * @date : 2019/10/13
 */
public class StringFactory {
    public static void main(String[] args) {
        String testString="0123456";
        StringBuilder builder=new StringBuilder(testString);
        System.out.println(builder.length());
        builder.delete(builder.length()-2,builder.length());
        System.out.println(builder);
    }
}
