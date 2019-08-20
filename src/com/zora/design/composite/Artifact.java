package com.zora.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>构件</p>
 *
 * @author : jyh
 * @date : 2019/08/20
 **/
public class Artifact extends AbstractArtifact{
    private int depth;
    private List<AbstractArtifact> queue;
    public Artifact(int depth){
        super(depth);
        this.queue=new ArrayList<>();
        this.depth=depth;
    }
    public Artifact(){}
    @Override
    public void add(AbstractArtifact artifact){
        queue.add(artifact);
    }
    @Override
    public void display(){
        for (int i=0;i<depth;i++){
            System.out.print("----");
        }
        System.out.println("this is an Artifact , depth is "+depth);
        for(AbstractArtifact artifact:queue){
            artifact.display();
        }
    }
}
