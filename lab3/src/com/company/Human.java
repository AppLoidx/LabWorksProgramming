package com.company;

public abstract class Human extends PhysObject {
    private String name;
    Human(String name){
        this.name = name;
    }

    void fall(){
        System.out.printf("%s %s начинает падать!\n", getType(), getName());
        state = State.FALL;
    }

    void flip(){
        System.out.printf("%s %s переворачивается!\n",getType(), getName());
        state = State.FLIP;
    }

    void explode(){
        System.out.printf("%s %s взрывается! Этого человека многие будут оплакивать...\n",getType(), getName());
        state = State.EXPLODE;
    }

    String getName(){
        return this.name;
    }
}
