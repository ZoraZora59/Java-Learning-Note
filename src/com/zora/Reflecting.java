package com.zora;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java反射特性测试
 *
 * @author Zora
 */
public class Reflecting {
    public static void main(String[] args) {
        reflectCreateInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }

    /**
     * 反射生成实例
     */
    static void reflectCreateInstance(){
        System.out.println("反射生成实例中：");
        try {
            Class<?> test = Class.forName("com.zora.ReflectionTesting");
            Object refInstance = test.newInstance();
            ReflectionTesting ref = (ReflectionTesting) refInstance;
            System.out.println("Public Number : " + ref.getPubNum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有构造方法
     */
    static void reflectPrivateConstructor(){
        System.out.println("反射私有构造方法中：");
        try {
            Class<?> test=Class.forName("com.zora.ReflectionTesting");
            Constructor<?> declearConstructor = test.getDeclaredConstructor(int.class,int.class);
            declearConstructor.setAccessible(true);
            Object refInstance=declearConstructor.newInstance(999,111);
            ReflectionTesting ref=(ReflectionTesting) refInstance;
            System.out.println("Public Number : " + ref.getPubNum());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反射私有属性
     */
    static void reflectPrivateField() {
        System.out.println("反射私有属性中：");
        try {
            Class<?> test = Class.forName("com.zora.ReflectionTesting");
            Object refInstance = test.newInstance();
            Field fieldNum = test.getDeclaredField("priNum");
            fieldNum.setAccessible(true);
            int priNum = (int) fieldNum.get(refInstance);
            System.out.println("Private Number : " + priNum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有方法
     */
    static void reflectPrivateMethod() {
        System.out.println("反射私有方法中：");
        try {
            Class<?> test = Class.forName("com.zora.ReflectionTesting");
            Method methodTesting = test.getDeclaredMethod("incPri",int.class);
            methodTesting.setAccessible(true);
            Object refInstance = test.newInstance();
            int priNum = (int) methodTesting.invoke(refInstance,123);
            System.out.println("Private Number : " + priNum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


