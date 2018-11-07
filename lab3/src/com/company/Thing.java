package com.company;

public abstract class Thing{
    protected Event event = Event.NONE;
    protected String type = "None";

    Boolean update() {
        return false;
    }
    String getType(){
        return this.type;
    }
}
