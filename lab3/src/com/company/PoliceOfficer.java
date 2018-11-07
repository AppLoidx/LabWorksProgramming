package com.company;

public class PoliceOfficer extends Human {

    private float accuracy;

    PoliceOfficer(String name, int accuracy){
        super(name);
        this.accuracy = accuracy;
    }

    void shot(Bullet bullet, PhysObject Target){
        if (Math.random() > accuracy){
            System.out.printf("Полицейский %s выстрелил и промахнулся!\n", getName());
        }else{
            System.out.printf("Полицейский %s выстрелил и попал!\n", getName());
            bullet.fire(Target);
        }
    }
    @Override
    Boolean update() {
        return true;
    }

}
