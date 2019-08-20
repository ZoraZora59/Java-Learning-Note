package com.zora.design.proxy;

import com.zora.RemovePointFromListNode;

import java.lang.reflect.Proxy;

/**
 * 调用类
 *
 * @author zora
 */
public class TargetObject {
    /**
     * 装饰者模式与代理模式，两个确实很像也容易弄混
     * 装饰者模式实现步骤:
     * 1.增强类与被增强类实现同一接口
     * 2.增强类里面得到被增强类的引用(只要在增强类里面传入被增强类对象的一定就是装饰者模式)
     * 3.对于不需要改写的方法,调用被增强类原有方法,对应需要改写增强的方法写自己的逻辑
     *
     * @param args null
     */
    public static void main(String[] args) {
        System.out.println("代理模式Demo\n");

        StaticProxyObject staticProxy = new StaticProxyObject();
        staticProxy.select("Static Proxy Database");

        System.out.println("配置为动态代理");
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler();
        RealObject proxyDuty=(RealObject)Proxy.newProxyInstance(AbstractRealObject.class.getClassLoader(),
                new Class[]{IUsage.class},new DynamicProxyHandler());
        proxyDuty.doSelect("Dynamic Proxy Database");
    }
}
