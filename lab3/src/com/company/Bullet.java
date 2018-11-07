package com.company;

public class Bullet extends PhysObject {

    private float pushPow;
    private float pow;

    Bullet() {
        pushPow = 20;
        pow = 26.3f;
    }
    Bullet(float pushPow, float pow){
        this.pushPow = pushPow;
        this.pow = pow;
    }

    void fire(PhysObject target){
        System.out.printf("Пуля попала в объект %s\n", target.getType());
        target.update();
        if (target instanceof Armored){
            if (((Armored) target).calculateDefence() < this.pow){
                target.event = Event.BREAK;
                return;
            }
        }
        if (target.heaviness < this.pushPow){
            target.event = Event.COLLISION;
            System.out.println("Урон был достаточно сильным чтобы иметь эффект!");
        }else{
            System.out.println("Урон был недостаточно сильным чтобы иметь эффект!");
        }
    }

    @Override
    Boolean update(){
        return true;
    }
}

