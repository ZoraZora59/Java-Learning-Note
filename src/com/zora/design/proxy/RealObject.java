package com.zora.design.proxy;

/**
 * 被代理类
 *
 * @author zora
 */
public class RealObject extends AbstractRealObject implements IUsage{
    @Override
    public void doSelect(String value) {
        System.out.println("Select " + value + ".....\nSelect Done.\n");
    }
}
