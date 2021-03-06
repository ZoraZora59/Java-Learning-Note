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
        withoutReflect();
        reflectCreateInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }

    /**
     * 不反射的情况下进行调用，只能调用public的
     */
    private static void withoutReflect(){
        System.out.println("普通实例化：");
        ReflectionTesting instance=new ReflectionTesting();
        System.out.println("Public Number : " + instance.getPubNum());
        instance.pubNum=10;
        instance.incPub(1);
        instance.decPub(2);
        System.out.println("After set(10)->inc(1)->dec(2) , public Number : " + instance.getPubNum());
    }

    /**
     * 反射生成实例
     */
    private static void reflectCreateInstance(){
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
     * 反射私有构造方法IdeaProjects/chatroom
     */
    private static void reflectPrivateConstructor(){
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
    private static void reflectPrivateField() {
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
    private static void reflectPrivateMethod() {
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

class ReflectionTesting {
    ReflectionTesting(){
        this.priNum=100;
        this.pubNum=50;
    }
    private ReflectionTesting(int pri,int pub){
        this.priNum=pri;
        this.pubNum=pub;
    }

    private int priNum ;
    int pubNum ;

    private int incPri(int inc) {
        priNum += inc;
        return priNum;
    }
    private int getPriNum(){
        return priNum;
    }
    private void decPri(int dec){
        priNum-=dec;
    }

    int incPub(int inc){
        pubNum+=inc;
        return pubNum;
    }
    int getPubNum(){
        return pubNum;
    }
    void decPub(int dec){
        pubNum-=dec;
    }
}
