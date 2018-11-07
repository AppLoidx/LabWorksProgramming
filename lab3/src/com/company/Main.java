package com.company;


public class Main {

    public static void main(String[] args) {

        // 20,  26.3f   --   все по условию задачи
        // 20,  260.3f  --   пуля пробьет ракету
        // 10,  26.3f   --   пуля не возымеет эффекта

        Bullet bullet = new Bullet(20,26.3f);

        Cosmonaut cosmonaut1 = new Cosmonaut("Sardana");
        Cosmonaut cosmonaut2 = new Cosmonaut("Masha");

        // можно задать параметры для Rocket см. Armor
        Rocket rocket = new Rocket();

        // добавление пассажиров
        rocket.addPassenger(cosmonaut1, cosmonaut2);

        PoliceOfficer martin = new PoliceOfficer("Martin", 1);

        Mainloop mainloop = new Mainloop();

        mainloop.createScene("Scene1");

        // Выстрел в ракету
        martin.shot(bullet, rocket);

        mainloop.addObjectsToScene("Scene1", bullet, cosmonaut1, cosmonaut2, rocket);
        mainloop.runScene("Scene1");

    }
}
