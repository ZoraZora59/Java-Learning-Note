package com.zora;

/**
 * 被反射的类
 *
 * @author Zora
 */
public class ReflectionTesting {
    public ReflectionTesting(){
        this.priNum=100;
        this.pubNum=50;
    }
    private ReflectionTesting(int pri,int pub){
        this.priNum=pri;
        this.pubNum=pub;
    }

    private int priNum ;
    public int pubNum ;

    private int incPri(int inc) {
        priNum += inc;
        return priNum;
    }
    private int getPriNum(){
        return priNum;
    }
    private void decPri(int dec){
        priNum-=dec;
    }

    public int incPub(int inc){
        pubNum+=inc;
        return pubNum;
    }
    public int getPubNum(){
        return pubNum;
    }
    public void decPub(int dec){
        pubNum-=dec;
    }
}
