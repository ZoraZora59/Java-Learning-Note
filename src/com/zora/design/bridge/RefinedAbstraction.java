package com.zora.design.bridge;

/**
 * <h3>Java-Learning-Note</h3>
 * <p></p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public class RefinedAbstraction extends Abstraction {

    //覆写构造函数
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    //修正父类行为
    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }

}

