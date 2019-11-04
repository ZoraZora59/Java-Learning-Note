package com.zora;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>列表的遍历与遍历时进行操作</p>
 *
 * @author : zora
 * @date : 2019/09/20
 */
public class ForeachIterator {
    public static void main(String[] args) {
        List<Integer> integerList=initList();
        integerList.removeIf(a -> a == 1);
        System.out.println(integerList);
    }
    static List<Integer> initList(){
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

}
