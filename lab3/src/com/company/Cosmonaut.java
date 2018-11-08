package com.company;

public class Cosmonaut extends Human {
    Cosmonaut(String name) {
        super(name);
        type = "Космонавт";
    }

    @Override
    Boolean update(){
        return true;
    }
}
