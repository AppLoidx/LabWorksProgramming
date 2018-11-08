package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mainloop {
    private Map<String,Scene> scenes = new HashMap<>();

    void createScene(String name){
        scenes.put(name,new Scene());
    }
    void runScene(String name){
        scenes.get(name).start();
    }
    void addObjectsToScene(String name, Thing ... objects){ scenes.get(name).addObject(objects);}
}
