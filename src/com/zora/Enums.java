package com.zora;

import java.util.Arrays;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>枚举</p>
 *
 * @author : zora
 * @date : 2019/12/01
 */
public class Enums {
    public static void main(String[] args) {
        System.out.println(types.type1.name());
        System.out.println(types.valueOf("type1"));
        System.out.println(types.type2);
        System.out.println(types.valueOf("type2"));
        System.out.println(Arrays.toString(types.values()));
    }
}
enum types{
    type1,
    type2;
}
enum objectTypes{
    type("dsaf",34);
    objectTypes(String name,int a){
        this.name=name;
        this.a=a;
    }
    String name;
    int a;
}
