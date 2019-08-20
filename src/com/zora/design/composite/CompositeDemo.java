package com.zora.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>JavaTesting</h3>
 * <p>设计模式-组合模式</p>
 *
 * @author zora
 * @date 2019/8/20
 */
public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("设计模式-组合模式Demo：\n");
        //初始化根节点
        AbstractComponent root = new Branch("根节点构件");

        //配置分支
        AbstractComponent branch1 = new Branch("分支构件1");
        branch1.add(new Extremity("末端构件1-1"));

        AbstractComponent branch2 = new Branch("分支构件2");
        AbstractComponent branch21 = new Branch("分支构件2-1");
        branch21.add(new Extremity("末端构件2-1-1"));
        branch2.add(branch21);

        AbstractComponent branch22 = new Branch("分支构件2-2");
        branch22.add(new Extremity("末端构件2-2-1"));
        branch22.add(new Extremity("末端构件2-2-2"));
        branch2.add(branch22);

        //组合构件
        root.add(branch1);
        root.add(branch2);
        root.add(new Branch("分支构件3"));
        root.add(new Extremity("末端构件3"));

        //使用构件
        root.function(1);
    }
}

/**
 * 抽象构件
 */
abstract class AbstractComponent {
    String mark;

    AbstractComponent(String mark) {
        this.mark = mark;
    }

    /**
     * 添加子节点
     *
     * @param component 节点实体
     */
    abstract void add(AbstractComponent component);

    /**
     * 删除子节点
     *
     * @param component 节点实体
     */
    abstract void remove(AbstractComponent component);

    /**
     * 显示结构
     *
     * @param depth 层级深度
     */
    abstract void function(int depth);
}

/**
 * 构件类型1：分支型
 */
class Branch extends AbstractComponent {

    Branch(String mark) {
        super(mark);
    }

    private List<AbstractComponent> components = new ArrayList<>();

    @Override
    void add(AbstractComponent component) {
        components.add(component);
    }

    @Override
    void remove(AbstractComponent component) {
        components.remove(component);
    }

    @Override
    void function(int depth) {
        for (int i = 1; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(mark);
        for (AbstractComponent component : components
        ) {
            component.function(depth + 1);
        }
    }
}

/**
 * 构件类型2：末端型
 */
class Extremity extends AbstractComponent {

    Extremity(String mark) {
        super(mark);
    }

    @Override
    void add(AbstractComponent component) {
    }

    @Override
    void remove(AbstractComponent component) {
    }

    @Override
    void function(int depth) {
        for (int i = 1; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(mark);
    }
}