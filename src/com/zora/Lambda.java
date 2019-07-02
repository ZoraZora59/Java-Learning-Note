package com.zora;

import java.util.ArrayList;

/**
 * Lambda表达式
 *
 * @author Zora
 */
public class Lambda {
    public static void main(String[] args) {
        ArrayList<LambdaTestingEntity> list=initList();
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).getName() + list.get(i).getAge());
        }
    }
    private static ArrayList<LambdaTestingEntity> initList(){
        ArrayList<LambdaTestingEntity> list=new ArrayList<>();
        list.add(new LambdaTestingEntity());
        return list;
    }
}
