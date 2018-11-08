package com.company;

public abstract class Human extends PhysObject {
    private String name;
    Human(String name){
        this.name = name;
    }

    protected void fall(){
        System.out.printf("%s %s начинает падать!\n", getType(), getName());
        state = State.FALL;
    }

    protected void flip(){
        System.out.printf("%s %s переворачивается!\n",getType(), getName());
        state = State.FLIP;
    }

    protected void explode(){
        System.out.printf("%s %s взрывается! Этого человека многие будут оплакивать...\n",getType(), getName());
        state = State.EXPLODE;
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


    String getName(){
        return this.name;
    }
}
