package com.zora.design.composite;

import java.util.List;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>抽象构件</p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public abstract class AbstractArtifact {
    private int depth;
    private List<Artifact> queue;

    public void add(AbstractArtifact artifact) {}

    public void display() {}

    public AbstractArtifact() {
    }
    public AbstractArtifact(int depth) {
        this.depth=depth;
    }
}
