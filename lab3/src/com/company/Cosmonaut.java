package com.company;

public class Cosmonaut extends Human {
    Cosmonaut(String name) {
        super(name);
        type = "Космонавт";
    }

    @Override
    void setState(State newState){
        if (state != newState){
            switch (newState){
                case FLIP:
                    flip();
                    fall();
                    break;
                case FALL:
                    fall();
                    break;
                case EXPLODE:
                    explode();
                    break;
            }
        }
    }

    @Override
    Boolean update(){
        return true;
    }
}
