package com.zora.design.proxy;

/**
 * 静态代理类
 *
 * @author zora
 */
public class StaticProxyObject {
    private RealObject real;

    StaticProxyObject() {
        System.out.println("静态代理实例化对象");
        real = new RealObject();
    }

    public void select(String value) {
        System.out.println("静态代理调用对象");
        real.doSelect(value);
    }
}
