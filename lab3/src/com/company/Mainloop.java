package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mainloop {
    private Map<String,Scene> scenes = new HashMap<>();

    private class Scene{

        Scene(Thing objects){
            addObject(objects);
        }

        Scene(){

        }

        Thing[] objects = new Thing[1000];
        Thing[] objectsCopy = new Thing[1000];

        void addObject(Thing ... things){
            int index = 0;
            int indexMax = things.length;

            for (int i =0; i<objects.length; i++) {
                if (objects[i] == null){
                    objects[i] = things[index];
                    if (++index == indexMax) break;
                }
            }
        }
        void start(){
            boolean end=false;
            while (!end) {
                for (int i = 0; i < objects.length; i++) {
                    objectsCopy[i] = objects[i];
                    if (objects[i] != null) {
                        if (!objects[i].update()){
                            end = true;
                            break;
                        }
                    }
                }
                if (checkToChanges(objectsCopy, objects)){
                    break;
                }
            }
        }

        boolean checkToChanges(Thing[] lastObjects, Thing[] newObjects){
            if (newObjects.length != lastObjects.length){
                return false;
            }
            for(int i=0; i< newObjects.length;i++){
                if (lastObjects[i] != null && newObjects[i] != null) {
                    if (!newObjects[i].equals(lastObjects[i])) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object obj){
            if (obj instanceof Scene){
                return Arrays.equals(((Scene) obj).objects, this.objects);
            }
            return false;
        }
    }

    void createScene(String name){
        scenes.put(name,new Scene());
    }
    void runScene(String name){
        scenes.get(name).start();
    }
    void addObjectsToScene(String name, Thing ... objects){ scenes.get(name).addObject(objects);}
}
