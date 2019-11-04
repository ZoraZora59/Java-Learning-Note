package com.zora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>迭代器练习</p>
 *
 * @author : jyh
 * @date : 2019/10/23
 */
public class IteratorControl {
    public static void main(String[] args) {
        List<ObjectClass> list=init();
        Iterator<ObjectClass> iterator=list.iterator();
        while (iterator.hasNext()){
            ObjectClass obj=iterator.next();
            if("描述1".equals(obj.note)){
                obj.note="Iterator";
            }
        }
        for (ObjectClass objectClass : list) {
            System.out.println(objectClass.name+"\t"+objectClass.note);
        }
    }
    private static List<ObjectClass> init(){
        List<ObjectClass> list=new ArrayList<>(3);
        ObjectClass obj = init(1);
        list.add(obj);
        obj=init(2);
        list.add(obj);
        obj=init(3);
        list.add(obj);
        return list;
    }
    private static ObjectClass init(int i){
        return new ObjectClass("名字"+i,"描述"+i);
    }
}

/**
 * 用于测试的类
 */
class ObjectClass{
    String name;
    String note;
    ObjectClass(String name,String note){
        this.name=name;
        this.note=note;
    }
}