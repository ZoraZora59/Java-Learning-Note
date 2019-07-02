package com.zora;

import java.util.*;

/**
 * 测试内存空间的使用，使用了LambdaTestingEntity实体类
 *
 * @author Zora
 */
public class MemSpace {
    public static void main(String[] args) {
        System.out.println("对象的内存空间查看");
        List<LambdaTestingEntity> list=new ArrayList<>();
        //实例化一个对象，赋值后添加到列表中并查看效果
        LambdaTestingEntity addOne=new LambdaTestingEntity();
        addOne.setAge(1);
        addOne.setName("对象1");
        list.add(addOne);
        for(LambdaTestingEntity i:list){
            System.out.println(i.getName()+"  "+i.getAge());
        }
        //修改这个对象，再添加到列表中，发现列表中现有两个相同的项，即两次都是同一个对象，原因是只new了一次。
        addOne.setName("对象1修改后");
        addOne.setAge(2);
        list.add(addOne);
        for(LambdaTestingEntity i:list){
            System.out.println(i.getName()+"  "+i.getAge());
        }
        System.out.println("普通变量的内存空间查看");
        List<Integer> a=new ArrayList<>();
        //初始化一个变量，赋值后加入列表，此时执行了装箱操作，实际上加入列表的是一个新的Integer对象，而非变量x。
        int x=1;
        a.add(x);
        for(int i:a){
            System.out.println(i);
        }
        //因此在修改后再次添加，实际上又添加了另一个新的Integer对象，这两个对象的值分别与x的修改前后相同，但是内存空间不相干。
        x=2;
        a.add(x);
        for(int i:a){
            System.out.println(i);
        }
    }
}
