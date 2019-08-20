package com.zora.design.composite;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>调用</p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public class TargetObject {
    public static void main(String[] args) {
        int startDepth=1;
        AbstractArtifact root=new Artifact(startDepth);

        root.add(new Artifact(startDepth+1));

        AbstractArtifact branch = new Artifact(startDepth+1);
        branch.add(new Artifact(startDepth+2));
        branch.add(new Artifact(startDepth+2));
        branch.add(new Artifact(startDepth+2));

        root.add(branch);

        AbstractArtifact doubleBranch = new Artifact(startDepth+2);
        doubleBranch.add(new Artifact(startDepth+3));
        doubleBranch.add(new Artifact(startDepth+3));

        branch.add(doubleBranch);

        root.add(new Artifact(startDepth+1));

        root.display();
    }
}
