package com.company;

public abstract class PhysObject extends Thing{

    protected Status status;
    protected State state = State.NONE;

    protected float heaviness;

    void collision(PhysObject withObj){
        withObj.event = Event.COLLISION;
        this.event = Event.COLLISION;
    }

    void setState(State newState){
        state = newState;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof PhysObject){
            if (((PhysObject) obj).state != state){
                return false;
            }
            if (((PhysObject) obj).status != status){
                return false;
            }
            if (((PhysObject) obj).heaviness != heaviness){
                return false;
            }
            if (((PhysObject) obj).event != event){
                return false;
            }
            return ((PhysObject) obj).type.equals(type);

        }
        return false;
    }

}
