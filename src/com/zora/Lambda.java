package com.zora;

import java.util.ArrayList;

/**
 * Lambda表达式
 *
 * @author Zora
 */
public class Lambda {
    public static void main(String[] args) {
        LambdaTest plus= Integer::sum;
        LambdaTest mul = (int a,int b)->a*b;
        int a=5,b=10;
        System.out.println(a+" + "+b+" = "+plus.culculate(a,b));
        System.out.println(a+" * "+b+" = "+mul.culculate(a,b));
    }
    interface LambdaTest{
        int culculate(int a, int b);
    }
}
