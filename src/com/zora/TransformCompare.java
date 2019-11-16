//package com.zora;
//
//
//import cn.hutool.core.bean.BeanUtil;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
///**
// * <h3>Java-Learning-Note</h3>
// * <p>类型转换效率对比</p>
// *
// * @author : jyh
// * @date : 2019/11/12
// */
//public class TransformCompare {
//
//    public static void main(String[] args) {
//        List<Father> fatherList;
//        List<Child> childList;
//        long endTime = 0;
//        long startTime = 0;
//
//        fatherList = initFather();
//        //获取开始时间
//        startTime = System.nanoTime();
//        childList=copyByListTransformWithObject(fatherList);
//        //获取结束时间
//        endTime = System.nanoTime();
//        System.out.println("强制转换，实体类写入方式，程序运行时间： " + (endTime - startTime) / 1000000.0 + "ms");
//
//        fatherList = initFather();
//        //获取开始时间
//        startTime = System.nanoTime();
//        childList=copyByListTransformWithT(fatherList);
//        //获取结束时间
//        endTime = System.nanoTime();
//        System.out.println("强制转换，泛型方式，程序运行时间： " + (endTime - startTime) / 1000000.0 + "ms");
//
//        //获取开始时间
//        fatherList= initFather();
//        startTime = System.nanoTime();
//        childList=copyByReflex(fatherList);
//        //获取结束时间
//        endTime = System.nanoTime();
//        System.out.println("反射程序运行时间： " + (endTime - startTime) / 1000000.0 + "ms");
//
//
//
//    }
//    private static List<Father> initFather(){
//        List<Father> list =new ArrayList<>();
//        int i=10000;
//        while(i!=0){
//            Father father=new Father();
//            father.intValue=i*4-1+i+31+i*21;
//            father.dateValue=new Date();
//            father.stringValue="打算发顺丰萨菲手动阀送达发"+i+"adsfsafas";
//            father.stringValue2="打丰萨菲手动阀送达发"+i+"ad132afas";
//            father.doubleValue=i*991+i*23.7-i/2.0;
//            list.add(father);
//            i--;
//        }
//        return list;
//    }
//    private static <T> List<T> copyByReflex(List source){
//        List<T> list = new ArrayList<>();
//        for (Object o : source) {
//            Object target=new Object();
//            BeanUtil.copyProperties(o, target);
//            list.add((T)target);
//        }
//        return list;
//    }
//    private static List<Child> copyByListTransformWithObject(List fathers){
//        Object[] object = fathers.toArray();
//        //使用Arrays工具类，将数组转换成list
//        List<Object> objects = Arrays.asList(object);
//        //将objects强转成childlist；这里强转时，不能定义后面括号内的List类型，如果定义会报编译错误
//        //及时child没有继承Parent，这里也不会报编译错误，但是按照Child对象循环输出时会报错
//        List<Child> voList = (List)objects;
//        return voList;
//    }
//    private static <T,E> List<E> copyByListTransformWithT(List<T> list){
//        List<E> result = new ArrayList<E>();
//        for (Object o : list) {
//            result.add((E)o);
//        }
//        return result;
//    }
//}
//
//class Father{
//    int intValue;
//    String stringValue;
//    String stringValue2;
//    double doubleValue;
//    Date dateValue;
//}
//class Child extends Father{}