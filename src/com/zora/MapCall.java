package com.zora;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>Map调用问题</p>
 *
 * @author : jyh
 * @date : 2019/10/18
 */
public class MapCall {
    public static void main(String[] args) {
        MapCall mapCall=new MapCall();
        Map<String,Boolean> map=new HashMap<>(10);
        map.put("NO1",true);
        map.put("NO2",true);
        System.out.println("Source : "+map);
        mapCall.callVoid(map);
        System.out.println("Void : "+map);
        map=mapCall.callMap(map);
        System.out.println("Map : "+map);
    }
    private void callVoid(Map<String, Boolean> theMap){
        theMap.put("VOID",false);
    }
    private Map<String,Boolean> callMap(Map<String,Boolean> theMap){
        theMap.put("MAP",false);
        return theMap;
    }
}
