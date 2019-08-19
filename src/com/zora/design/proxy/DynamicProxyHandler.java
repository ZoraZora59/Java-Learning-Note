package com.zora.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 *
 * @author zora
 */
public class DynamicProxyHandler implements InvocationHandler {
    private RealObject realObject;
    public DynamicProxyHandler(){
        realObject=new RealObject();
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(realObject, args);
    }
}
