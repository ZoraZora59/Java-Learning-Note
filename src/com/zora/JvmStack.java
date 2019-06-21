package com.zora;

/**
 * 测试JVM的栈调用深度
 *
 * @author Zora
 */

public class JvmStack {

    private static int index = 1;

    public void call(){
        index++;
        call();
    }

    public static void main(String[] args) {
        JvmStack mock = new JvmStack();
        try {
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
//            e.printStackTrace();
        }
    }
}